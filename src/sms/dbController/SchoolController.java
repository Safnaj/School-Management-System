package sms.dbController;

import sms.db.DBConnection;
import sms.model.School;
import sms.model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Safnaj on 8/26/2018
 * @project School Management System
 **/
public class SchoolController {

    public static School schoolInfo() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM schoolinfo";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rst=stm.executeQuery();
        if(rst.next()){
            School s=new School(rst.getString("SchoolName"),rst.getString("SchoolAddress"),rst.getString("classAvailable"),
                    rst.getString("schoolType"), rst.getString("deoDivision"), rst.getString("municpalCouncil"), rst.getString("policeArea"),
                    rst.getString("postalCode"), rst.getString("gsDivision"), rst.getString("eduZone"), rst.getString("eduDistrict"),
                    rst.getString("adminDistrict"), rst.getString("electorate"), rst.getString("dateOfEstd"), rst.getString("schoolID"),
                    rst.getString("schoolCensus"), rst.getString("schoolExamId"), rst.getString("totalLandArea"), rst.getString("province"),
                    rst.getString("nameOfPrincipal"), rst.getString("pricipalNo"));

            return s;
        }
        return null;
    }

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

    public static int updateInfo(School school) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE schoolinfo SET SchoolName= ? ,SchoolAddress= ? ,classAvailable= ? ,schoolType= ? ,deoDivision= ? ,municpalCouncil= ? ,policeArea=? ,postalCode= ? " +
                ",gsDivision= ? ,eduZone= ? ,eduDistrict=? ,adminDistrict=? ,electorate=? ,dateOfEstd=? ,schoolID=? ,schoolCensus=? ,schoolExamId=? ,totalLandArea=? ,province=?" +
                ",nameOfPrincipal=? , pricipalNo=? ";
        Connection conn = DBConnection.getDBConnection().getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setObject(1, school.getSchoolName());
        stm.setObject(2, school.getSchoolAddress());
        stm.setObject(3, school.getClassAvailable());
        stm.setObject(4, school.getSchoolType());
        stm.setObject(5, school.getDeoDivision());
        stm.setObject(6, school.getMunicpalCouncil());
        stm.setObject(7, school.getPoliceArea());
        stm.setObject(8, school.getPostalCode());
        stm.setObject(9, school.getGsDivision());
        stm.setObject(10,school.getEduZone());
        stm.setObject(11,school.getEduDistrict());
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
