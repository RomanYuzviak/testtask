/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ClientsStats;

/**
 *
 * @author Roman
 */
public class ClientsStatsService {
    private static final String url = "jdbc:postgresql://localhost/testtaskdb?user=postgres&password=admin";
    public List<ClientsStats> getStats() throws SQLException {
        Connection conn = DriverManager.getConnection(url);
        
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT kod_zkpo_a, name_cli_a,"
                + " kod_zkpo_b, name_cli_b, COUNT(*) as amount,"
                + " SUM(suma_op) AS total_sum FROM finmon.docdays201903\n"
                + "GROUP BY kod_zkpo_a, name_cli_a, kod_zkpo_b, name_cli_b;");
        List<ClientsStats> statsList = new ArrayList<>();
            while (rs.next()) {
                String codeA = rs.getString("kod_zkpo_a");
                String nameA = rs.getString("name_cli_a");
                String codeB = rs.getString("kod_zkpo_b");
                String nameB = rs.getString("name_cli_b");
                Long sum = rs.getLong("total_sum");
                Integer amount = rs.getInt("amount");
                ClientsStats record = new ClientsStats(
                    codeA, 
                    nameA, 
                    codeB,
                    nameB,
                    sum,
                    amount
                );
                statsList.add(record);
            }
            rs.close();
            st.close();
            return statsList;
    }
}
