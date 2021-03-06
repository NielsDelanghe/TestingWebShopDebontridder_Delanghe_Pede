package ui.view;

import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class PayCart extends RequestHandler {

    private PayConfirmation payConfirmation = new PayConfirmation();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        payConfirmation.setService(getService());

        HttpSession session = request.getSession();

        List<Product> lijst = (List<Product>) session.getAttribute("cart");

        session.setAttribute("PayList",lijst);

        try {
            response.sendRedirect("Controller?action=PayConfirmation");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
