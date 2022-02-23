package com.revature.nbaplayers;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class NBAServer {
    private Tomcat server;
    SearchFormService sfService = new SearchFormService();

    public NBAServer(NBAService nbaService) {
        this.server = new Tomcat();
        this.server.setBaseDir(System.getProperty("java.io.tmpdir"));
        this.server.getConnector();
        this.server.addContext("",null);
        this.server.addServlet("","nbaServlet",nbaService).addMapping("/NBA-Players");
        this.server.addServlet("", "searchFormServlet", sfService).addMapping("/search");
        try {
            this.server.start();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
