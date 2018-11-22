package ui.view;

import domain.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogIn extends RequestHandler {

    Index index = new Index();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        index.setService(getService());
        String id = request.getParameter("userid");
        String pass = request.getParameter("password");
        setService(getService());
        Person p = getService().getPerson(id);

        HttpSession loginSession = request.getSession();

        String message=null;

        if(p.getPassword().equals(pass))
        {
            loginSession.setAttribute("user",p);
            return index.handleRequest(request,response);
        }

        else
        {
            message="Verkeerd password voor de userid";
        }


        request.setAttribute("message",message);
        return "LogIn.jsp";
    }
}
