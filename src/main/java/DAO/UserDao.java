package DAO;

import Model.Users;
import connect.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    static List<Users> listUser;
    public static Users isValidUser(String email, String pass) {
        String query = "SELECT * FROM users WHERE email = ? AND password = ?";
        try {
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                Users users = new Users(rs.getString(3), rs.getString(4));
                return users;
            }
        } catch (Exception e) {}
        return null;
    }

    public static void main(String[] args) {
        System.out.println(isValidUser("admin","1"));
    }
}
