package ui.view;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index extends RequestHandler {
    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {


        return getIndexPage(request,  getValueOfCookieShowQuote(request));
    }

    protected String getIndexPage(HttpServletRequest request, String preference) {
        request.setAttribute("quote",preference);
        request.setAttribute(preference+"Checked","checked");

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
