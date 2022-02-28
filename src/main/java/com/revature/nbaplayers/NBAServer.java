package com.revature.nbaplayers;

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
        server.addServlet(webAppName,"nbaServlet",nbaService).addMapping("/players");
        server.addServlet(webAppName, "searchPlayerFormServlet", new SearchPlayerFormService()).addMapping("/searchPlayer");
        server.addServlet(webAppName, "searchTeamFormServlet", new SearchTeamFormService()).addMapping("/searchTeam");
        try {
            server.start();
            System.out.println("Server running on http://localhost:" + server.getConnector().getLocalPort() + webAppName);
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
