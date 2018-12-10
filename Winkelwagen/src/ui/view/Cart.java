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

public class Cart extends RequestHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        double price = 0;
        int aantalItems = 0;
        HttpSession session = request.getSession();
        List<Product> lijst = (ArrayList<Product>) session.getAttribute("cart");

        if(lijst != null)
        {
            for(Product pr : lijst)
            {
                price += pr.getPrice() * pr.getQuantity();
            }
        }
        else
        {
            lijst = new ArrayList<>();
        }

        for(Product p : lijst)
        {
            aantalItems += p.getQuantity();
        }
        request.setAttribute("totalPrice",price);
        session.setAttribute("items",aantalItems);
        request.setAttribute("items",aantalItems);

        RequestDispatcher view = request.getRequestDispatcher("ShoppingCart.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "ShoppingCart.jsp";

    }
}
