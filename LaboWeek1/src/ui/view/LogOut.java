package ui.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOut extends RequestHandler {



    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        setService(getService());
        HttpSession session =request.getSession();
        session.removeAttribute("user");

        return "LogIn.jsp";
    }
}
