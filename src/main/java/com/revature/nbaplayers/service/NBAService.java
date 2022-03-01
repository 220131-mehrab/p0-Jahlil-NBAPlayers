package com.revature.nbaplayers.service;

import com.revature.nbaplayers.repository.NBARepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class NBAService extends HttpServlet {
    private NBARepository nbaRepository;

    public NBAService(NBARepository nbaRepository) {
        this.nbaRepository = nbaRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String playerSearchInput, teamSearchInput, positionSearchInput;
        playerSearchInput = req.getParameter("searchPlayer");
        teamSearchInput = req.getParameter("searchTeam");
        positionSearchInput = req.getParameter("searchPosition");

        if (playerSearchInput != null){
            String result = nbaRepository.getPlayer(playerSearchInput);
            resp.getWriter().println(result);
        }else if(teamSearchInput != null){
            List<String> result = nbaRepository.getTeam(teamSearchInput);
            for (String player : result){
                resp.getWriter().println(player);
            }
        }else if(positionSearchInput != null){
            List<String> result = nbaRepository.getPositions(positionSearchInput);
            for (String player : result){
                resp.getWriter().println(player);
            }
        }else{
            for (String player : nbaRepository.getPlayers()){
                resp.getWriter().println(player);
            }
        }
    }
}
