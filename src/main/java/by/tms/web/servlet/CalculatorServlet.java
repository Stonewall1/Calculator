package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    private CalculatorService calculatorService = new CalculatorService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Operation operation = new Operation();
        operation.setX1(Double.parseDouble(req.getParameter("x1")));
        operation.setX2(Double.parseDouble(req.getParameter("x2")));
        operation.setOperation(req.getParameter("operation"));
        operation.setUser((User) req.getSession().getAttribute("currentUser"));
        operation = calculatorService.calculate(operation);
        req.setAttribute("result" , operation);

        getServletContext().getRequestDispatcher("/pages/calculator.jsp").forward(req , resp);
    }
}
