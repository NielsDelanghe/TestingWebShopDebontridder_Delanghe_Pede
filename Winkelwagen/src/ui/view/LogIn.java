package ui.view;

import domain.model.Person;
import domain.model.Role;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class LogIn extends RequestHandler {

    Index index = new Index();

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        index.setService(getService());
        String id = request.getParameter("userid");
        String pass = request.getParameter("password");
        Person p = getService().getPerson(id);

        HttpSession loginSession = request.getSession();
        try {
            pass = p.hashPassword(pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        String message=null;

        if(p.getPassword().equals(pass))
        {

            loginSession.setAttribute("user",p);
            try {
                response.sendRedirect("Controller?action=Index");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "";
        }

        else
        {
            message="Verkeerd password voor de userid";
        }


        request.setAttribute("message",message);
        RequestDispatcher view = request.getRequestDispatcher("LogIn.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "LogIn.jsp";
    }
}
