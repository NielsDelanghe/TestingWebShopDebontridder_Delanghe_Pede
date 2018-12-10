package ui.view;

import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuantity extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        int productId = Integer.parseInt(request.getParameter("productId"));
        String quantity = request.getParameter("quantity");
        int quantityInt = Integer.parseInt(quantity);
        Product p = getService().getProduct(productId);

        HttpSession session = request.getSession();
        List<Product> lijst = (ArrayList<Product>) session.getAttribute("cart");
        if(lijst != null)
        {
            for(Product pr : lijst)
            {
                if(pr.getProductId() == p.getProductId())
                {
                    pr.setQuantity(quantityInt);
                }
            }
        }

        RequestDispatcher view = request.getRequestDispatcher("Controller?action=Cart");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";



    }
}
