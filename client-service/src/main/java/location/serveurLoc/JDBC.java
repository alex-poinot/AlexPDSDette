package location.serveurLoc;

import location.serveurLoc.serveurLoc;
import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBC {
    public static int choix = 0;

    public void setChoix(int c) {
        choix = c;
    }
    public int getChoix() {
        return choix;
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;

        Properties props = new Properties();
        try (FileInputStream fis = new FileInputStream("backend-service/properties")) {
            props.load(fis);
        }

        /*String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String pwd = props.getProperty("jdbc.password");*/

        String url = props.getProperty("jdbc.url");
        String login = props.getProperty("jdbc.login");
        String pwd = props.getProperty("jdbc.password");

        try {
            conn = DriverManager.getConnection(url, login, pwd);
            if (conn != null) {
                System.out.println("CONNECTION OK");
            } else {
                System.out.println("CONNECTION FAILED");
            }


            switch (choix) {
                case 1:
                    Statement statement1 = conn != null ? conn.createStatement() : null;

                    ResultSet rs1 = statement1.executeQuery("SELECT * FROM USERS");

                    while (rs1.next()) {

                    }
                    break;
                case 2:
                    Statement statement2 = conn != null ? conn.createStatement() : null;

                    ResultSet rs2 = statement2.executeQuery("");

                    while (rs2.next()) {

                    }
                    break;
                case 3:
                    Statement statement3 = conn != null ? conn.createStatement() : null;

                    ResultSet rs3 = statement3.executeQuery("1");

                    while (rs3.next()) {

                    }
                    break;
                case 4:
                    Statement statement4 = conn != null ? conn.createStatement() : null;

                    ResultSet rs4 = statement4.executeQuery("2");

                    while (rs4.next()) {

                    }
                    break;
            }


        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
