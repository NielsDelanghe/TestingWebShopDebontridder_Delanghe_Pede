package ui.view;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductOverview extends RequestHandler{



    public String  handleRequest(HttpServletRequest request, HttpServletResponse response) {
        setService(getService());
        request.setAttribute("products", getService().getProducts());
        return "productoverview.jsp";
    }
}
