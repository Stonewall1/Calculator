package by.tms.web.servlet;

import by.tms.storage.OperationStorage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/story")
public class OperationsStoryServlet extends HttpServlet {
    private final OperationStorage operationStorage = new OperationStorage();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("operations" , operationStorage.getOperations());
        getServletContext().getRequestDispatcher("/pages/story.jsp").forward(req , resp);
    }
}
