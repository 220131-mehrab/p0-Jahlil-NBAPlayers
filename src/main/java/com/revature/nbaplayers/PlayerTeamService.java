package com.revature.nbaplayers;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class PlayerTeamService extends HttpServlet {
    private NBARepository nbaRepository;

    public PlayerTeamService(NBARepository nbaRepository) {
        this.nbaRepository = nbaRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String teamSearchInput;
        teamSearchInput = req.getParameter("searchTeam");

        if (teamSearchInput != null){
            List<String> result = nbaRepository.getTeam(teamSearchInput);
            for ( String player : result){
                resp.getWriter().println(player);
            }
        }else{
            for( String player : nbaRepository.getPlayers()){
                resp.getWriter().println(player);
            }
        }
    }
}
