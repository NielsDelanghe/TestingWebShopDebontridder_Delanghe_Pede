package ui.view;

import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RemoveProductFromCart extends RequestHandler {

    Cart cart = new Cart();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        cart.setService(getService());
        HttpSession session = request.getSession();
        int id = Integer.parseInt(request.getParameter("productId"));
        Product p = getService().getProduct(id);


        List<Product> lijst = (ArrayList<Product>) session.getAttribute("cart");

        for( int i=0; i< lijst.size(); i++)
        {
            if(lijst.get(i).getName().equals(p.getName()))
            {
                lijst.remove(i);
            }
        }

        session.setAttribute("cart",lijst);


        try {
            response.sendRedirect("Controller?action=Cart");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
