package ui.view;

import domain.model.Person;
import domain.model.ShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class CheckPasswordConfirmation extends RequestHandler {


    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response){
        String pass = request.getParameter("password");
        String id = request.getParameter("userid");
        Person p = getService().getPerson(id);
        try {
            pass =p.hashPassword(pass);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String message =null;

        if(p.getPassword().equals(pass))
        {
            message="The password is correct";
        }

        else
        {
            message="The password is not correct";
        }

        request.setAttribute("message",message);

        return "checkPassword.jsp";
    }
}
