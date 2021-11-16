package com.example.accessingdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;
    private String address;
    private String email;
    private int phone;
    private LocalDate startOfMembership;
    private LocalDate durationOfMembership;
    private String membershipType;
    private int currentNumTournaments;
    private int pastNumTournaments;
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

    public LocalDate getStartOfMembership() {
        return startOfMembership;
    }

    public void setStartOfMembership(LocalDate startOfMembership) {
        this.startOfMembership = startOfMembership;
    }

    public LocalDate getDurationOfMembership() {
        return durationOfMembership;
    }

    public void setDurationOfMembership(LocalDate durationOfMembership) {
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