package sms.model;

/**
 * @author Safnaj on 8/26/2018
 * @project School Management System
 **/
public class School {
    private String SchoolName;
    private String SchoolAddress;
    private int classAvailable;
    private String schoolType;
    private String deoDivision;
    private String municpalCouncil;
    private String policeArea;
    private int postalCode;
    private String gsDivision;
    private String eduZone;
    private String eduDistrict;
    private String adminDistrict;
    private String electorate;
    private String dateOfEstd;
    private String schoolID;
    private String schoolCensus;
    private String schoolExamId;
    private String totalLandArea;
    private String province;
    private String nameOfPrincipal;
    private int pricipalNo;

    public School(String schoolName, String schoolAddress, int classAvailable, String schoolType, String deoDivision, String municpalCouncil, String policeArea, int postalCode, String gsDivision, String eduZone, String eduDistrict, String adminDistrict, String electorate, String dateOfEstd, String schoolID, String schoolCensus, String schoolExamId, String totalLandArea, String province, String nameOfPrincipal, int pricipalNo) {
        SchoolName = schoolName;
        SchoolAddress = schoolAddress;
        this.classAvailable = classAvailable;
        this.schoolType = schoolType;
        this.deoDivision = deoDivision;
        this.municpalCouncil = municpalCouncil;
        this.policeArea = policeArea;
        this.postalCode = postalCode;
        this.gsDivision = gsDivision;
        this.eduZone = eduZone;
        this.eduDistrict = eduDistrict;
        this.adminDistrict = adminDistrict;
        this.electorate = electorate;
        this.dateOfEstd = dateOfEstd;
        this.schoolID = schoolID;
        this.schoolCensus = schoolCensus;
        this.schoolExamId = schoolExamId;
        this.totalLandArea = totalLandArea;
        this.province = province;
        this.nameOfPrincipal = nameOfPrincipal;
        this.pricipalNo = pricipalNo;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getSchoolAddress() {
        return SchoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        SchoolAddress = schoolAddress;
    }

    public int getClassAvailable() {
        return classAvailable;
    }

    public void setClassAvailable(int classAvailable) {
        this.classAvailable = classAvailable;
    }

    public String getSchoolType() {
        return schoolType;
    }

    public void setSchoolType(String schoolType) {
        this.schoolType = schoolType;
    }

    public String getDeoDivision() {
        return deoDivision;
    }

    public void setDeoDivision(String deoDivision) {
        this.deoDivision = deoDivision;
    }

    public String getMunicpalCouncil() {
        return municpalCouncil;
    }

    public void setMunicpalCouncil(String municpalCouncil) {
        this.municpalCouncil = municpalCouncil;
    }

    public String getPoliceArea() {
        return policeArea;
    }

    public void setPoliceArea(String policeArea) {
        this.policeArea = policeArea;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getGsDivision() {
        return gsDivision;
    }

    public void setGsDivision(String gsDivision) {
        this.gsDivision = gsDivision;
    }

    public String getEduZone() {
        return eduZone;
    }

    public void setEduZone(String eduZone) {
        this.eduZone = eduZone;
    }

    public String getEduDistrict() {
        return eduDistrict;
    }

    public void setEduDistrict(String eduDistrict) {
        this.eduDistrict = eduDistrict;
    }

    public String getAdminDistrict() {
        return adminDistrict;
    }

    public void setAdminDistrict(String adminDistrict) {
        this.adminDistrict = adminDistrict;
    }

    public String getElectorate() {
        return electorate;
    }

    public void setElectorate(String electorate) {
        this.electorate = electorate;
    }

    public String getDateOfEstd() {
        return dateOfEstd;
    }

    public void setDateOfEstd(String dateOfEstd) {
        this.dateOfEstd = dateOfEstd;
    }

    public String getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(String schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolCensus() {
        return schoolCensus;
    }

    public void setSchoolCensus(String schoolCensus) {
        this.schoolCensus = schoolCensus;
    }

    public String getSchoolExamId() {
        return schoolExamId;
    }

    public void setSchoolExamId(String schoolExamId) {
        this.schoolExamId = schoolExamId;
    }

    public String getTotalLandArea() {
        return totalLandArea;
    }

    public void setTotalLandArea(String totalLandArea) {
        this.totalLandArea = totalLandArea;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNameOfPrincipal() {
        return nameOfPrincipal;
    }

    public void setNameOfPrincipal(String nameOfPrincipal) {
        this.nameOfPrincipal = nameOfPrincipal;
    }

    public int getPricipalNo() {
        return pricipalNo;
    }

    public void setPricipalNo(int pricipalNo) {
        this.pricipalNo = pricipalNo;
    }
}
