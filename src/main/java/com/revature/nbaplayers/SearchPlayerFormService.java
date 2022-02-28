package com.revature.nbaplayers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SearchPlayerFormService extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String HtmlForm = "<Html>\n" +
                "<head>\n" +
                "    <title>NBA Current Players Records</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h1>NBA Custom Rosters</h1>\n" +
                "<form action='Players-Roster' method='get'> \n" +
                "    <input type='name' name='searchPlayer'/>\n" +
                "    <input type='submit' value='Search'/>\n" +
                "    <a href='Players-Roster'> See Players List</a>\n" +
                "</form>\n" +
                "</body>\n" +
                "</Html>";
        resp.getWriter().println(HtmlForm);
    }
}
