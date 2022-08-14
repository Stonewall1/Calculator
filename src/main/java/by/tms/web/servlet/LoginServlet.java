package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.RegistrationService;
import by.tms.web.constants.ServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet(value = "/login", name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    private final RegistrationService registrationService = new RegistrationService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(ServletConstants.LOGIN).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Optional<User> byEmail = registrationService.findByEmail(email);
        if (byEmail.isPresent()) {
            User user = byEmail.get();
            if (user.getPassword().equals(password)) {
                req.getSession().setAttribute("currentUser", user);
                resp.sendRedirect(ServletConstants.START_PAGE);
            } else {
                req.setAttribute("message", "Wrong password");
                getServletContext().getRequestDispatcher(ServletConstants.LOGIN).forward(req, resp);
            }
        } else {
            req.setAttribute("message", "User not found");
            getServletContext().getRequestDispatcher(ServletConstants.LOGIN).forward(req, resp);
        }
    }
}
