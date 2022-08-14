package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import by.tms.service.validation.OperationValidation;
import by.tms.web.constants.ServletConstants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet(value = "/calculator", name = "CalculatorServlet")
public class CalculatorServlet extends HttpServlet {

    private final CalculatorService calculatorService = new CalculatorService();
    private final OperationValidation operationValidation = new OperationValidation();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(ServletConstants.CALCULATOR).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Operation operation = new Operation();
        operation.setUser((User) req.getSession().getAttribute("currentUser"));
        if (operationValidation.isFieldsEmpty(req.getParameter("x1"),
                req.getParameter("x2"),
                req.getParameter("operation"))) {
            req.setAttribute("message", "Fields cant be empty");
            getServletContext().getRequestDispatcher(ServletConstants.CALCULATOR).forward(req, resp);
        } else {
            operation.setX1(Double.parseDouble(req.getParameter("x1")));
            operation.setX2(Double.parseDouble(req.getParameter("x2")));
            operation.setOperation(req.getParameter("operation"));
            if (!operationValidation.wrongOperationFieldFilling(operation.getOperation())) {
                operation.setTime(LocalDateTime.now());
                operation = calculatorService.calculate(operation);
                req.setAttribute("result", operation);
                getServletContext().getRequestDispatcher(ServletConstants.CALCULATOR).forward(req, resp);
            } else {
                req.setAttribute("message", "Enter right operation");
                getServletContext().getRequestDispatcher(ServletConstants.CALCULATOR).forward(req, resp);
            }
        }
    }
}
