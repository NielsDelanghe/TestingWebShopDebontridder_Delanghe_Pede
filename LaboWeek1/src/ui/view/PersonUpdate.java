package ui.view;

import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonUpdate extends RequestHandler {



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("userid");
        Person p =getService().getPerson(id);

        request.setAttribute("person",p);
        return "updateperson.jsp";
    }
}
