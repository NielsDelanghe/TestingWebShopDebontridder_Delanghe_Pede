package ui.view;

import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PersonUpdate extends RequestHandler {



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("userid");
        Person p =getService().getPerson(id);

        request.setAttribute("person",p);
        RequestDispatcher view = request.getRequestDispatcher("updateperson.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "updateperson.jsp";
    }
}
