package ui.view;

import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class PersonUpdateConfirmation extends RequestHandler {

    private PersonOverview personOverview = new PersonOverview();



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("userid");
        String email = request.getParameter("email");
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        Person p = null;
        try {
            p = new Person(id,email,".",firstname,lastname);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        getService().updatePersons(p);
        personOverview.setService(getService());
        try {
            response.sendRedirect("Controller?action=PersonOverview");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
