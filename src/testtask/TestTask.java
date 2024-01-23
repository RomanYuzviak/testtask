/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testtask;

import java.sql.*;
import java.util.List;
import java.util.Properties;
import model.ClientsStats;
import service.ClientsStatsService;

/**
 *
 * @author Roman
 */
public class TestTask {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        
//        String url = "jdbc:postgresql://localhost/testtaskdb";
//        Properties props = new Properties();
//        props.setProperty("user", "postgres");
//        props.setProperty("password", "admin");
//        Connection conn = DriverManager.getConnection(url, props);
        
        ClientsStatsService srvs = new ClientsStatsService();
        List<ClientsStats> l = srvs.getStats();
        for (ClientsStats cs : l) {
            System.out.println(cs);
        }
    }
    
}
