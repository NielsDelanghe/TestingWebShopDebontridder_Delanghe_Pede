package ui.view;

import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProduct extends RequestHandler {



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        Product p = getService().getProduct(Integer.parseInt(id));
        request.setAttribute("product",p);

        return "deleteproduct.jsp";
    }
}
