package com.revature.nbaplayers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchFormService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HtmlForm = "<Html>\n" +
                "<head>\n" +
                "    <title>NBA Current Players Records</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action='/' method='get'> \n" +
                "    <input type='name' name='searchName'/>\n" +
                "    <input type='submit' value='Search'/>\n" +
                "</form>\n" +
                "</body>\n" +
                "</Html>";
        resp.getWriter().println(HtmlForm);
    }
}
