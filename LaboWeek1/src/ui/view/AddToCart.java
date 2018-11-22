package ui.view;

import domain.model.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class AddToCart extends RequestHandler {

    ProductOverview productOverview = new ProductOverview();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        productOverview.setService(getService());
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = getService().getProduct(productId);
        HttpSession session = request.getSession();

        List<Product> list = (List<Product>) session.getAttribute("cart");

        if(list == null)
        {
            list = new ArrayList<>();
        }

        list.add(product);

        session.setAttribute("cart",list);

        return productOverview.handleRequest(request,response);
    }
}
