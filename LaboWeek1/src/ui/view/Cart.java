package ui.view;

import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class Cart extends RequestHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        double price=0;

        HttpSession session = request.getSession();
        List<Product> lijst = (ArrayList<Product>) session.getAttribute("cart");

        if(lijst!=null)
        {
            for(Product pr : lijst)
            {
                price+=pr.getPrice();
            }

        }

        else
        {
            lijst=new ArrayList<>();
        }

        request.setAttribute("totalPrice",price);
        return "ShoppingCart.jsp";

    }
}
