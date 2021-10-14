package com.csse.model;

public class Staff {
    private int mobileNumber;
    private String position;
    private String userId;
    private int staffId;
    private String userName;
    private String userRole;
    private String userPass;
    private String userMail;

    public int getStaffId() {
        return staffId;
    }

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "mobileNumber='" + mobileNumber + '\'' +
                ", position='" + position + '\'' +
                ", userId='" + userId + '\'' +
                ", staffId='" + staffId + '\'' +
                ", userName='" + userName + '\'' +
                ", userRole='" + userRole + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userMail='" + userMail + '\'' +
                '}';
    }
}
