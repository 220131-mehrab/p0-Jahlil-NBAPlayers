package com.revature.nbaplayers;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class NBAServer {
    private Tomcat server;

    public NBAServer(NBAService nbaService) {
        this.server = new Tomcat();
        this.server.getConnector();
        this.server.addContext("",null);
        this.server.addServlet("","nbaServlet",nbaService).addMapping("/");
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
