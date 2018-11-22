package ui.view;

import domain.db.PersonDbInMemory;
import domain.db.ProductDbInMemory;
import domain.model.DomainException;
import domain.model.Person;
import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    public Controller(){super();}

    //private PersonDbInMemory persons = new PersonDbInMemory();
    private ShopService service = new ShopService();
    //private ProductDbInMemory products = new ProductDbInMemory();
    private HandlerFactory controllerFactory = new HandlerFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            processRequest(request,response);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {

        String action = request.getParameter("action");
        String destination = "index.jsp";
        if ( action == null)
            action = "Index";
        if(action !=null)
        {
            RequestHandler handler;
            handler = controllerFactory.getController(action,service);
            destination = handler.handleRequest(request,response);
        }

        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request,response);
    }

}
