package edu.episen.si.ing1.pds.backend.server.release2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class Crud {


    /*public static StringBuilder requestbuilding(Connection connection, Map<String, String> map) {

        StringBuilder sb = null;
        try {
            String sql = "SELECT building_name FROM building";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("nnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn");
        return sb;
    }

    public static StringBuilder requestFloor(Connection connection, Map<String, String> map) {
        StringBuilder sb = null;
        System.out.println("tutu4");
        try {

            String sql = "SELECT name_floor FROM Floor INNER JOIN Building ON floor.id_floor = building.id_building WHERE Building.id_building = 3";
            ResultSet rs = connection.createStatement().executeQuery(sql);
            System.out.println(sql);
            sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getString(1) + "@");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sb;

    }
*/
}

