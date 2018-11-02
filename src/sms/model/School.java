package sms.model;

/**
 * @author Safnaj on 8/26/2018
 * @project School Management System
 **/
public class School {
    private String schoolName;
    private String schoolAddress;
    private String classAvailable;
    private String schoolType;
    private String deoDivision;
    private String municpalCouncil;
    private String policeArea;
    private String postalCode;
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
    private String pricipalNo;

    public School(){

    }

    public School(String schoolName, String schoolAddress, String classAvailable, String schoolType, String deoDivision, String municpalCouncil, String policeArea, String postalCode, String gsDivision, String eduZone, String eduDistrict, String adminDistrict, String electorate, String dateOfEstd, String schoolID, String schoolCensus, String schoolExamId, String totalLandArea, String province, String nameOfPrincipal, String pricipalNo) {
        this.schoolName = schoolName;
        this.schoolAddress = schoolAddress;
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
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        schoolName = schoolName;
    }

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        schoolAddress = schoolAddress;
    }

    public String getClassAvailable() {
        return classAvailable;
    }

    public void setClassAvailable(String classAvailable) {
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
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

    public String getPricipalNo() {
        return pricipalNo;
    }

    public void setPricipalNo(String pricipalNo) {
        this.pricipalNo = pricipalNo;
    }
}
