package com.team11.domain;

import java.util.Date;

public class MaskOrder {

    private Long mid;
    private Long uid;
    private String uname;   //下单姓名
    private Long rid;
    private String rname;   //收件人姓名
    private Integer ptype;  //证件类型
    private String pnumber; //证件号码
    private String rtel;
    private String address; //收获地址
    private String saddress;    //医院地址
    private Date atime; //送达时间
    private Integer mtype;  //口罩类型
    private Integer mnumber;    //口罩数量
    private Date ordertime; //下单时间

    private String y11;
    private String y12;
    private String y13;
    private String y14;

    private Integer state_flag;

    public MaskOrder() {}
    public MaskOrder(Long mid, Long uid, String uname, Long rid, String rname, Integer ptype, String pnumber, String rtel, String address, String saddress, Date atime, Integer mtype, Integer mnumber, Date ordertime, String y11, String y12, String y13, String y14, Integer state_flag) {
        this.mid = mid;
        this.uid = uid;
        this.uname = uname;
        this.rid = rid;
        this.rname = rname;
        this.ptype = ptype;
        this.pnumber = pnumber;
        this.rtel = rtel;
        this.address = address;
        this.saddress = saddress;
        this.atime = atime;
        this.mtype = mtype;
        this.mnumber = mnumber;
        this.ordertime = ordertime;
        this.y11 = y11;
        this.y12 = y12;
        this.y13 = y13;
        this.y14 = y14;
        this.state_flag = state_flag;
    }

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
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

    public String getRtel() {
        return rtel;
    }

    public void setRtel(String rtel) {
        this.rtel = rtel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSaddress() {
        return saddress;
    }

    public void setSaddress(String saddress) {
        this.saddress = saddress;
    }

    public Date getAtime() {
        return atime;
    }

    public void setAtime(Date atime) {
        this.atime = atime;
    }

    public Integer getMtype() {
        return mtype;
    }

    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    public Integer getMnumber() {
        return mnumber;
    }

    public void setMnumber(Integer mnumber) {
        this.mnumber = mnumber;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
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

    public Integer getState_flag() {
        return state_flag;
    }

    public void setState_flag(Integer state_flag) {
        this.state_flag = state_flag;
    }

    @Override
    public String toString() {
        return "MaskOrder{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", uname='" + uname + '\'' +
                ", rid=" + rid +
                ", rname='" + rname + '\'' +
                ", ptype=" + ptype +
                ", pnumber='" + pnumber + '\'' +
                ", rtel='" + rtel + '\'' +
                ", address='" + address + '\'' +
                ", saddress='" + saddress + '\'' +
                ", atime=" + atime +
                ", mtype=" + mtype +
                ", mnumber=" + mnumber +
                ", ordertime=" + ordertime +
                ", y11='" + y11 + '\'' +
                ", y12='" + y12 + '\'' +
                ", y13='" + y13 + '\'' +
                ", y14='" + y14 + '\'' +
                ", state_flag=" + state_flag +
                '}';
    }
}
