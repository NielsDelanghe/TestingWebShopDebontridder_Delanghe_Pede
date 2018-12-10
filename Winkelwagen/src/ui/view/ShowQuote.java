package ui.view;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowQuote extends Index{

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {

        String button = request.getParameter("quote");
        request.setAttribute("quote",button);

        Cookie cookie = new Cookie("showQuote", button);
        response.addCookie(cookie);

        return getIndexPage(request,button,response);

    }

}
