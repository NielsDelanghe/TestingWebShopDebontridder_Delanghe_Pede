package ui.view;

import domain.db.PersonDbInMemory;
import domain.db.ProductDbInMemory;
import domain.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

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
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        String destination = "index.jsp";

        if ( action == null) {
            action = "Index";

            List<Product> list = (List<Product>) session.getAttribute("cart");

            if(list == null)
            {

                list = new ArrayList<>();
            }

            session.setAttribute("items",list.size());

        }

        if(action !=null)
        {
            RequestHandler handler;
            handler = controllerFactory.getController(action,service);

            try {

                destination = handler.handleRequest(request,response);

            }catch (NotAuthorizedException e)
            {
                request.setAttribute("notAuthorized", "You have insufficient rights to have a look at the requested page.");
                RequestDispatcher view = request.getRequestDispatcher(destination);
                view.forward(request,response);

            }

        }

        //RequestDispatcher view = request.getRequestDispatcher(destination);
        //view.forward(request,response);
    }

}
