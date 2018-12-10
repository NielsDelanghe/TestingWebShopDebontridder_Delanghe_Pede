package ui.view;

import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProductOverview extends RequestHandler{



    public String  handleRequest(HttpServletRequest request, HttpServletResponse response) {
        setService(getService());
        request.setAttribute("products", getService().getProducts());

        if(request.getParameter("p")!=null)
        {
            request.setAttribute("p",getService().getProduct(Integer.parseInt(request.getParameter("p"))));
        }

        RequestDispatcher view = request.getRequestDispatcher("productoverview.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "productoverview.jsp";
    }
}
