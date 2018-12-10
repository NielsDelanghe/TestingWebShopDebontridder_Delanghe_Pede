package ui.view;

import domain.model.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Index extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        return getIndexPage(request,  getValueOfCookieShowQuote(request),response);

    }

    protected String getIndexPage(HttpServletRequest request, String preference, HttpServletResponse response) {
        request.setAttribute("quote",preference);
        request.setAttribute(preference+"Checked","checked");

        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        try {
            view.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index.jsp";

    }

    private String getValueOfCookieShowQuote(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie cookie : cookies)
                if (cookie.getName().equals("showQuote"))
                    return cookie.getValue();
                return "";

    }
}
