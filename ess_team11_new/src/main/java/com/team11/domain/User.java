package com.team11.domain;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    private Integer uid;
    private String uname;
    private String truename;
    private String upass;
    private String utel;
    private String email;

    private String photo;
    private Integer sex;
    private Integer ptype;
    private String pnumber;
    private Date birthday;
    private String country;
    private Integer identity;

    private String y11;
    private String y12;
    private String y13;
    private String y14;

    public User() {}
    public User(Integer uid, String uname, String truename, String upass, String utel, String email, String photo, Integer sex, Integer ptype, String pnumber, Date birthday, String country, Integer identity, String y11, String y12, String y13, String y14) {
        this.uid = uid;
        this.uname = uname;
        this.truename = truename;
        this.upass = upass;
        this.utel = utel;
        this.email = email;
        this.photo = photo;
        this.sex = sex;
        this.ptype = ptype;
        this.pnumber = pnumber;
        this.birthday = birthday;
        this.country = country;
        this.identity = identity;
        this.y11 = y11;
        this.y12 = y12;
        this.y13 = y13;
        this.y14 = y14;
    }

    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname;
    }
    public String getTruename() {
        return truename;
    }
    public void setTruename(String truename) {
        this.truename = truename;
    }
    public String getUpass() {
        return upass;
    }
    public void setUpass(String upass) {
        this.upass = upass;
    }
    public String getUtel() {
        return utel;
    }
    public void setUtel(String utel) {
        this.utel = utel;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoto() {
        return photo;
    }
    public void setPhoto(String photo) {
        this.photo = photo;
    }
    public Integer getSex() {
        return sex;
    }
    public void setSex(Integer sex) {
        this.sex = sex;
    }
    public Integer getPtype() {
        return ptype;
    }
    public void setPtype(Integer ptype) {
        this.ptype = ptype;
    }
    public String getPnumber() {
        return pnumber;
    }
    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public Integer getIdentity() {
        return identity;
    }
    public void setIdentity(Integer identity) {
        this.identity = identity;
    }
    public String getY11() {
        return y11;
    }
    public void setY11(String y11) {
        this.y11 = y11;
    }
    public String getY12() {
        return y12;
    }
    public void setY12(String y12) {
        this.y12 = y12;
    }
    public String getY13() {
        return y13;
    }
    public void setY13(String y13) {
        this.y13 = y13;
    }
    public String getY14() {
        return y14;
    }
    public void setY14(String y14) {
        this.y14 = y14;
    }

}
