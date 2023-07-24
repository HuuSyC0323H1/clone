package DAO;


import Model.Users;
import connect.DBConnect;
import Model.Photos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PhotoDao {
   static Connection conn = null;
   static PreparedStatement ps = null;
   static ResultSet rs = null;
    public static List<Photos> getListPhoto(){
        List<Photos> list = new ArrayList<>();
        String query = "SELECT * FROM photo";
        try{
            conn = new DBConnect().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Photos(rs.getString(2), rs.getString(3)));

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        PhotoDao photoDao = new PhotoDao();
        List<Photos> list = photoDao.getListPhoto();
        for (Photos p: list) {
            System.out.println(p);
        }
    }
}
