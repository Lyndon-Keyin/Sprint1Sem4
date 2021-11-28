package com.example.accessingdatarest;

import javax.persistence.*;
import java.util.List;

@Entity
public class MembershipType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String membershipType;

    public  MembershipType(){

    }
    public MembershipType(long id, String membershipType){
        this.id = id;
        this.membershipType = membershipType;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }





}
