package ui.view;

import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeletePerson extends RequestHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("userid");
        System.out.println("userid: "+id);
        Person p = getService().getPerson(id);
        System.out.println("person: "+p.getLastName());
        request.setAttribute("person",p);

        return "deleteperson.jsp";
    }
}
