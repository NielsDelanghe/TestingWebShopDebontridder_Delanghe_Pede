package ui.view;

import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePersonConfirmation extends RequestHandler {

    private PersonOverview personOverview = new PersonOverview();



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("userid");
        String button = request.getParameter("submit");

        if(button.equals("Ja"))
        {
            getService().deletePerson(id);
        }
        personOverview.setService(getService());

        try {
            response.sendRedirect("Controller?action=PersonOverview");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}
