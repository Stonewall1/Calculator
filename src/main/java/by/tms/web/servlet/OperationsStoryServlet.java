package by.tms.web.servlet;

import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.storage.OperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/story")
public class OperationsStoryServlet extends HttpServlet {
    private final OperationStorage operationStorage = new OperationStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Operation> ops = new ArrayList<>();
        User user = (User) req.getSession().getAttribute("currentUser");
         for(Operation operation : operationStorage.getOperations()){
             if(operation.getUser().getId() == user.getId()){
                 ops.add(operation);
             }
         }
         req.setAttribute("operations" , ops);
         getServletContext().getRequestDispatcher(Constants.story).forward(req , resp);
    }
}
