package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import by.tms.service.validation.OperationValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/calculator")
public class CalculatorServlet extends HttpServlet {

    private final CalculatorService calculatorService = new CalculatorService();
    private final OperationValidation operationValidation = new OperationValidation();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher(Constants.calculator).forward(req , resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Operation operation = new Operation();
        operation.setUser((User) req.getSession().getAttribute("currentUser"));

        boolean isEmpty = operationValidation.isFieldsEmpty(req.getParameter("x1")
                , req.getParameter("x2")
                , req.getParameter("operation"));
        if(isEmpty){
            req.setAttribute("message", "Fields cant be empty");
            getServletContext().getRequestDispatcher(Constants.calculator).forward(req, resp);
        }
        else{
            operation.setX1(Double.parseDouble(req.getParameter("x1")));
            operation.setX2(Double.parseDouble(req.getParameter("x2")));
            operation.setOperation(req.getParameter("operation"));

            boolean isOperationFieldFilledWrong = operationValidation.wrongOperationFieldFilling(operation.getOperation());
            if(!isOperationFieldFilledWrong){
                operation.setTime(LocalDateTime.now());
                operation = calculatorService.calculate(operation);

                req.setAttribute("result" , operation);
                getServletContext().getRequestDispatcher(Constants.calculator).forward(req , resp);
            }
            else{
                req.setAttribute("message", "Enter right operation");
                getServletContext().getRequestDispatcher(Constants.calculator).forward(req, resp);
            }
        }
    }
}
