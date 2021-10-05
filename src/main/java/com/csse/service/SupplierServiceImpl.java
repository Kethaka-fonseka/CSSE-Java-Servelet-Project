package com.csse.service;

public class SupplierServiceImpl {

    private String companyName;
    private String mobileNumber;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "SupplierServiceImpl{" +
                "companyName='" + companyName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
