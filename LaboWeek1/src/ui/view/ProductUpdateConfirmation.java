package ui.view;

import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductUpdateConfirmation extends RequestHandler {

    private ProductOverview productOverview = new ProductOverview();


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        String naam = request.getParameter("name");
        String desc = request.getParameter("description");
        String prijs=request.getParameter("price");
        Product p =getService().getProduct(Integer.parseInt(id));
        p.setName(naam);
        p.setDescription(desc);
        p.setPrice(prijs);
        getService().updateProduct(p);

        productOverview.setService(getService());
        return productOverview.handleRequest(request,response);
    }
}
