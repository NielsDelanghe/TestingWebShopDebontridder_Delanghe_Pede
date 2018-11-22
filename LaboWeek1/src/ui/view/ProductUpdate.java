package ui.view;

import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductUpdate extends RequestHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        Product pro =getService().getProduct(Integer.parseInt(id));

        request.setAttribute("product",pro);
        return "productupdate.jsp";
    }
}
