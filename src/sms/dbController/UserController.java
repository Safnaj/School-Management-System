package sms.dbController;

import sms.db.DBConnection;
import sms.model.Staff;
import sms.model.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Safnaj on 11/9/2018
 * @project School Management System
 **/
public class UserController {

    public static int addUser(User user)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO users VALUES(?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, user.getUsername());
        stm.setObject(2, user.getPassword());

        return  stm.executeUpdate();
    }

    public static int updateUser(User user) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE users SET username= ? ,password= ?  WHERE username= '" +user.getUsername()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, user.getUsername());
        stm.setObject(2, user.getPassword());

        return  stm.executeUpdate();
    }

    public static int deleteUser(String username) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM users WHERE username ='"+username+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }

    public static ArrayList <User> getAllUsers() throws ClassNotFoundException, SQLException{
        Connection conn=DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From users");
        ArrayList <User> userList = new ArrayList<>();
        while(rst.next()){
            User user;
            user = new User(rst.getString(1),rst.getString(2));
            userList.add(user);
        }
        return userList;
    }
    public static User searchUser(String username) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM users WHERE username = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, username);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            User user = new User(rst.getString("username"),rst.getString("password"));
            return user;
        }
        return null;
    }
}
