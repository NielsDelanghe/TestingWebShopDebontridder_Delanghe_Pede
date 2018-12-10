package ui.view;

import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteProduct extends RequestHandler {



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        Product p = getService().getProduct(Integer.parseInt(id));
        request.setAttribute("product",p);


        RequestDispatcher view = request.getRequestDispatcher("deleteproduct.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "deleteproduct.jsp";
    }
}
