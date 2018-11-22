package ui.view;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonOverview extends RequestHandler {



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("persons",getService().getPersons());
        return "personoverview.jsp";
    }
}
