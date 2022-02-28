package com.revature.nbaplayers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class NBAService extends HttpServlet {
    private NBARepository nbaRepository;

    public NBAService(NBARepository nbaRepository) {
        this.nbaRepository = nbaRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerSearchInput;
        playerSearchInput = req.getParameter("searchPlayer");
        resp.getWriter().println("Is this working???");

        if (playerSearchInput != null){
            String result = nbaRepository.getPlayer(playerSearchInput);
            resp.getWriter().println(result);
        } else {
            for (String player : nbaRepository.getPlayers()){
                resp.getWriter().println(player);
            }
        }
    }
}
