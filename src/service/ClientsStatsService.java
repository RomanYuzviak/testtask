package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.ClientsStats;

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
    
    public List<ClientsStats> getStatsForUsers(String zkpoA, String zkpoB) throws SQLException {        
        String sql = "SELECT kod_zkpo_a, name_cli_a, kod_zkpo_b, name_cli_b, suma_op AS sum " +
             "FROM finmon.docdays201903 " +
             "GROUP BY kod_zkpo_a, name_cli_a, kod_zkpo_b, name_cli_b, suma_op " +
             "HAVING kod_zkpo_a = ? AND kod_zkpo_b = ?";
        List<ClientsStats> statsList = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(url);
            PreparedStatement preparedStatement = conn.prepareStatement(sql)) {

            preparedStatement.setString(1, zkpoA);
            preparedStatement.setString(2, zkpoB);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    String codeA = rs.getString("kod_zkpo_a");
                    String nameA = rs.getString("name_cli_a");
                    String codeB = rs.getString("kod_zkpo_b");
                    String nameB = rs.getString("name_cli_b");
                    Long sum = rs.getLong("sum");
                    ClientsStats record = new ClientsStats(
                        codeA, 
                        nameA, 
                        codeB,
                        nameB,
                        sum,
                        null
                    );
                    statsList.add(record);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         return statsList;
    }
}
