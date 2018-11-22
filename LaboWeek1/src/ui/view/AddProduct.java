package ui.view;

import domain.model.DomainException;
import domain.model.Product;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class AddProduct extends RequestHandler {

    private ProductOverview productOverview = new ProductOverview();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        productOverview.setService(getService());
        ArrayList<String> error2 = new ArrayList<>();
        Product pr = new Product();

        getProductId(pr,request,error2);
        getName(pr,request,error2);
        getDescription(pr,request,error2);
        getPrice(pr,request,error2);


        if(error2.size()==0){
            try{
                getService().addProduct(pr);
                return productOverview.handleRequest(request,response);
            }catch (IllegalArgumentException e){
                request.setAttribute("errors",e.getMessage());
                return "Add.jsp";
            }
        }
        else{
            request.setAttribute("errors",error2);
            return "Add.jsp";
        }
    }

    private void getProductId(Product p, HttpServletRequest request, ArrayList<String>error)
    {
        String id = request.getParameter("productId");
        try{
            p.setProductId(Integer.parseInt(id));
            request.setAttribute("PreId",Integer.parseInt(id));

        }catch(NumberFormatException ex){
            error.add(ex.getMessage());
        }
    }

    private void getName(Product p, HttpServletRequest request, ArrayList<String>error)
    {
        String name = request.getParameter("name");
        try{
            p.setName(name);
            request.setAttribute("PreName",name);

        }catch(DomainException ex){
            error.add(ex.getMessage());
        }
    }

    private void getDescription(Product p, HttpServletRequest request, ArrayList<String>error)
    {
        String desc = request.getParameter("description");
        try{
            p.setDescription(desc);
            request.setAttribute("PreDesc",desc);

        }catch(DomainException ex){
            error.add(ex.getMessage());
        }
    }

    private void getPrice(Product p, HttpServletRequest request, ArrayList<String>error)
    {
        String price = request.getParameter("price");
        try{
            p.setPrice(price);
            request.setAttribute("PrePrice",price);

        }catch(DomainException ex){
            error.add(ex.getMessage());
        }
    }
}
