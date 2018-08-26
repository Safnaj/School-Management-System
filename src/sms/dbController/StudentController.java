package sms.dbController;

import sms.model.Student;
import sms.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
