package sms.dbController;

import sms.db.DBConnection;
import sms.model.School;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Safnaj on 8/26/2018
 * @project School Management System
 **/
public class SchoolController {

    public static int AddDetails(School school)throws ClassNotFoundException,SQLException {
        String SQL="INSERT INTO schoolinfo VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(SQL);
        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getSchoolType());
        stm.setObject(5, school.getDeoDivision());
        stm.setObject(6, school.getMunicpalCouncil());
        stm.setObject(7, school.getPoliceArea());
        stm.setObject(8, school.getPostalCode());
        stm.setObject(9, school.getGsDivision());
        stm.setObject(10, school.getEduZone());
        stm.setObject(11, school.getEduDistrict());
        stm.setObject(12, school.getAdminDistrict());
        stm.setObject(13, school.getElectorate());
        stm.setObject(14, school.getDateOfEstd());
        stm.setObject(15, school.getSchoolID());
        stm.setObject(16, school.getSchoolCensus());
        stm.setObject(17, school.getSchoolExamId());
        stm.setObject(18, school.getTotalLandArea());
        stm.setObject(19, school.getProvince());
        stm.setObject(20, school.getNameOfPrincipal());
        stm.setObject(21, school.getPricipalNo());


        return  stm.executeUpdate();
    }
}
