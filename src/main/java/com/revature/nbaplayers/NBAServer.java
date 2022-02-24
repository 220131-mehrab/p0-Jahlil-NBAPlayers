package com.revature.nbaplayers;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class NBAServer {
    private Tomcat server;
    SearchFormService sfService = new SearchFormService();
    String webAppName = "NBA-Players-Roster";

    public NBAServer(NBAService nbaService) {
        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tmpdir"));
        this.server.getConnector();
        this.server.addContext(webAppName,null);
        this.server.addServlet(webAppName,"nbaServlet",nbaService).addMapping("/");
        this.server.addServlet(webAppName, "searchFormServlet", sfService).addMapping("/search");
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
