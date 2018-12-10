package ui.view;

import domain.model.NotAuthorizedException;
import domain.model.Person;
import domain.model.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPage extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        Person p = (Person) request.getSession().getAttribute("user");

        if(p == null || p.getRole()!= Role.ADMIN)
        {
            throw new NotAuthorizedException();
        }

        RequestDispatcher view = request.getRequestDispatcher("Add.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "Add.jsp";
    }
}
