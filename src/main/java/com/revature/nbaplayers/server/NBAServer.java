package com.revature.nbaplayers.server;

import com.revature.nbaplayers.service.NBAService;
import com.revature.nbaplayers.servlet.DefaultServlet;
import com.revature.nbaplayers.servlet.SearchPlayerFormService;
import com.revature.nbaplayers.servlet.SearchPositionFormService;
import com.revature.nbaplayers.servlet.SearchTeamFormService;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class NBAServer {
    String webAppName = "/Players-Roster";

    public NBAServer(NBAService nbaService) {
        Tomcat server = new Tomcat();
        server.setBaseDir(System.getProperty("java.io.tmpdir"));
        server.setPort(0);
        server.getConnector();
        server.addContext(webAppName,null);
        server.addServlet(webAppName, "DefaultServlet", new DefaultServlet()).addMapping("/*");
        server.addServlet(webAppName,"nbaServlet",nbaService).addMapping("/list");
        server.addServlet(webAppName, "searchPlayerFormServlet", new SearchPlayerFormService())
                .addMapping("/searchPlayer");
        server.addServlet(webAppName, "searchTeamFormServlet", new SearchTeamFormService())
                .addMapping("/searchTeam");
        server.addServlet(webAppName, "searchPositionFormServlet", new SearchPositionFormService())
                .addMapping("/searchPosition");
        try {
            server.start();
            System.out.println("Server running on http://localhost:" + server.getConnector().getLocalPort() + webAppName);
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
