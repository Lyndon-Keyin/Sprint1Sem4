package com.example.accessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private int phone;
    //private LocalDate startOfMembership;
    @Column
    private int durationOfMembership;
    @Column
    private String membershipType;
    @Column
    private int currentNumTournaments;
    @Column
    private int pastNumTournaments;
    @Column
    private int futureNumTournaments;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    //public LocalDate getStartOfMembership() {
    //    return startOfMembership;
   // }

    //public void setStartOfMembership(LocalDate startOfMembership) {
    //    this.startOfMembership = startOfMembership;
    //}

    public int getDurationOfMembership() {
        return durationOfMembership;
    }

    public void setDurationOfMembership(int durationOfMembership) {
        this.durationOfMembership = durationOfMembership;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String membershipType) {
        this.membershipType = membershipType;
    }

    public int getCurrentNumTournaments() {
        return currentNumTournaments;
    }

    public void setCurrentNumTournaments(int currentNumTournaments) {
        this.currentNumTournaments = currentNumTournaments;
    }

    public int getPastNumTournaments() {
        return pastNumTournaments;
    }

    public void setPastNumTournaments(int pastNumTournaments) {
        this.pastNumTournaments = pastNumTournaments;
    }

    public int getFutureNumTournaments() {
        return futureNumTournaments;
    }

    public void setFutureNumTournaments(int futureNumTournaments) {
        this.futureNumTournaments = futureNumTournaments;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}