package sms.dbController;

import javafx.scene.control.Alert;
import sms.model.Student;
import sms.db.DBConnection;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Safnaj on 8/25/2018
 * @project School Management System
 **/
public class StudentController {

    public static int AddStudent(Student student)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO students VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getDob());
        stm.setObject(5, student.getDoa());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getGrade());
        stm.setObject(8, student.getParentName());
        stm.setObject(9, student.getNic());
        stm.setObject(10, student.getPhone());
        stm.setObject(11, student.getAddress());

        return  stm.executeUpdate();
    }
    public static Student searchStudent(Integer adNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM students WHERE adNo = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, adNo);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student s=new Student(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11));
            return s;
        }
        return null;
    }

    public static Student searchPastStudent(Integer adNo) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM leftstudents WHERE adNo = ? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, adNo);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            Student s=new Student(rst.getInt(1),rst.getString(2),rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11));
            return s;
        }
        return null;
    }

    public static int deleteStudent(String adNo) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Students WHERE adNo ='"+adNo+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);


        return  stm.executeUpdate();
    }

    public static int deleteLeftStudent(String adNo) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM leftstudents WHERE adNo ='"+adNo+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);


        return  stm.executeUpdate();
    }

    public static int moveStudent(Student student)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO leftstudents VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getDob());
        stm.setObject(5, student.getDoa());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getGrade());
        stm.setObject(8, student.getParentName());
        stm.setObject(9, student.getNic());
        stm.setObject(10, student.getPhone());
        stm.setObject(11, student.getAddress());

        return  stm.executeUpdate();
    }

    public static int updateStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE students SET adNo= ? ,fullName= ? ,name= ? ,dob= ? ,doa= ? ,gender= ? ,grade=? ,parentName= ? ,nic= ? ,phone= ? ,address=? WHERE adNo= '" +student.getAdNo()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getDob());
        stm.setObject(5,student.getDoa());
        stm.setObject(6,student.getGender());
        stm.setObject(7,student.getGrade());
        stm.setObject(8,student.getParentName());
        stm.setObject(9,student.getNic());
        stm.setObject(10,student.getPhone());
        stm.setObject(11,student.getAddress());

        return  stm.executeUpdate();
    }

    public static int updateLeftStudent(Student student) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE leftstudents SET adNo= ? ,fullName= ? ,name= ? ,dob= ? ,doa= ? ,gender= ? ,grade=? ,parentName= ? ,nic= ? ,phone= ? ,address=? WHERE adNo= '" +student.getAdNo()+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getDob());
        stm.setObject(5,student.getDoa());
        stm.setObject(6,student.getGender());
        stm.setObject(7,student.getGrade());
        stm.setObject(8,student.getParentName());
        stm.setObject(9,student.getNic());
        stm.setObject(10,student.getPhone());
        stm.setObject(11,student.getAddress());

        return  stm.executeUpdate();
    }


}
