package by.tms.web.servlet;

import by.tms.entity.User;
import by.tms.service.RegistrationService;
import by.tms.service.validation.UserRegistrationValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/registration")
public class RegistrationServlet extends HttpServlet {
    private final RegistrationService registrationService = new RegistrationService();
    private final UserRegistrationValidation userRegistrationValidation = new UserRegistrationValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setName(req.getParameter("name"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        boolean userExistsInStorage = userRegistrationValidation.checkUserInStorage(user);
        boolean fieldsEmpty = userRegistrationValidation.checkIsFieldsEmpty(user);

        if(!userExistsInStorage && !fieldsEmpty){
            registrationService.register(user);
            resp.sendRedirect("/");
        }
        else{
            if(userExistsInStorage){
                req.setAttribute("message", "That user already registered");
                getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("message", "Fields cant be empty");
                getServletContext().getRequestDispatcher("/pages/registration.jsp").forward(req, resp);
            }
        }
    }
}