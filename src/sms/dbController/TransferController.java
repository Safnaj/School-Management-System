package sms.dbController;

import sms.db.DBConnection;
import sms.model.Student;
import sms.model.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Safnaj on 11/5/2018
 * @project School Management System
 **/
public class TransferController {

    public static int transferStudent(ArrayList<Student> student) throws ClassNotFoundException, SQLException {
        String SQL="INSERT INTO paststudents VALUES(?,?,?,?,?,?,?,?,?,?,?)";
       //String SQL="INSERT INTO paststudents(adNo,fullName,name,dob,doa,gender,year,parentName,nic,phone,)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        /*stm.setObject(1, student.getAdNo());
        stm.setObject(2, student.getFullName());
        stm.setObject(3, student.getName());
        stm.setObject(4, student.getDob());
        stm.setObject(5, student.getDoa());
        stm.setObject(6, student.getGender());
        stm.setObject(7, student.getGrade());
        stm.setObject(8, student.getParentName());
        stm.setObject(9, student.getNic());
        stm.setObject(10, student.getPhone());
        stm.setObject(11, student.getAddress());*/

        return stm.executeUpdate();
    }

    public static int updateGrade(String year) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE paststudents SET year= '" + year + "'  WHERE year= 'Grade 5'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(1, student.getGrade());

        return stm.executeUpdate();
    }

    public static int deleteStudent(String grade) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Students WHERE grade ='" + grade + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return stm.executeUpdate();
    }

    public static ArrayList<Student> getGrade5() throws ClassNotFoundException, SQLException {
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery("Select * From students Where grade = 'Grade 5'");
        ArrayList<Student> studentList = new ArrayList<>();
        while (rst.next()) {
            Student student = new Student(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9), rst.getString(10), rst.getString(11));
            studentList.add(student);
        }
        return studentList;
    }
}
