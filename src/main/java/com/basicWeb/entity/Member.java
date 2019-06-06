package com.basicWeb.entity;

import com.basicWeb.utility.HandleString;

public class Member {
    private String UserName;
    private String Email;
    private String Password;
    private String Address;
    private String Phone;
    private int Status;
    private String Salt;

    public Member() {
        this.UserName = "";
        this.Password = "";
        this.Email = "";
        this.Address = "";
        this.Phone = "";
    }

    public enum MemberStatus {
        ACTIVE(1), DEACTIVE(0), DELETE(-1);

        private int value;

        MemberStatus(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static MemberStatus findByValue(int value) {
            for (MemberStatus status : MemberStatus.values()) {
                if (status.getValue() == value) {
                    return status;
                }
            }
            return null;
        }
    }

    public String getSalt() {
        return Salt;
    }

    public void setSalt(String salt) {
        Salt = salt;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(MemberStatus status) {
        if (status == null) {
            status = MemberStatus.ACTIVE;
        }
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }
}
