package sms.dbController;

import sms.db.DBConnection;
import sms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Safnaj on 11/5/2018
 * @project School Management System
 **/
public class TransferController {

    public static int transferStudent(Student student, String grade)throws ClassNotFoundException,SQLException {
        String SQL=("INSERT INTO paststudents (?,?,?,?,?,?,?,?,?,?,?)" +
                "SELECT * FROM students WHERE grade = '"+grade+"'");
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

    public static int updateGrade(String grade) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE students SET grade=?  WHERE grade= '" +grade+ "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
//        stm.setObject(1, student.getGrade());

        return  stm.executeUpdate();
    }

    public static int deleteStudent(String grade) throws ClassNotFoundException, SQLException {

        String sql = "DELETE FROM Students WHERE grade ='"+grade+"'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);

        return  stm.executeUpdate();
    }
}
