package ui.view;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteProductConfirmation extends RequestHandler {

    private ProductOverview productOverview = new ProductOverview();


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("productId");
        String button = request.getParameter("submit");

        if(button.equals("Ja"))
        {
            getService().deleteProduct(Integer.parseInt(id));
        }
        productOverview.setService(getService());
        return productOverview.handleRequest(request,response);
    }
}
