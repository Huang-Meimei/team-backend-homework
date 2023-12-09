package com.team11.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data @AllArgsConstructor
public class NucleicAcid {
    private Long nid;
    private Long uid;
    private String uname;
    private int ptype;
    private String pnumber;
    private String tel;
    private String address;
    private String saddress;
    private Date ntime;
    private Date ordertime;
}
