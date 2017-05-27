package com.study.bean;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private Integer id;

    private String code;

    private String customerName;

    private Byte isSign;

    private String mobile;

    private Byte type;

    private Date createData;

    public Customer(Integer id, String code, String customerName, Byte isSign, String mobile, Byte type, Date createData) {
        this.id = id;
        this.code = code;
        this.customerName = customerName;
        this.isSign = isSign;
        this.mobile = mobile;
        this.type = type;
        this.createData = createData;
    }

    public Customer() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public Byte getIsSign() {
        return isSign;
    }

    public void setIsSign(Byte isSign) {
        this.isSign = isSign;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Date getCreateData() {
        return createData;
    }

    public void setCreateData(Date createData) {
        this.createData = createData;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", customerName='" + customerName + '\'' +
                ", isSign=" + isSign +
                ", mobile='" + mobile + '\'' +
                ", type=" + type +
                ", createData=" + createData +
                '}';
    }
}