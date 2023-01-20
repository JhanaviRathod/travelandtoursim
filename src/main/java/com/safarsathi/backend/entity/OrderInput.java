package com.safarsathi.backend.entity;

import java.util.List;

public class OrderInput {

    private  String fullname;
    private  String fullAddress;
    private  String contactNumber;
    private  String alternatecontactNumber;
    private List<OrderPackageQuantity> orderPackageQuantityList;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getAlternatecontactNumber() {
        return alternatecontactNumber;
    }

    public void setAlternatecontactNumber(String alternatecontactNumber) {
        this.alternatecontactNumber = alternatecontactNumber;
    }

    public List<OrderPackageQuantity> getOrderPackageQuantityList() {
        return orderPackageQuantityList;
    }

    public void setOrderPackageQuantityList(List<OrderPackageQuantity> orderPackageQuantityList) {
        this.orderPackageQuantityList = orderPackageQuantityList;
    }
}
