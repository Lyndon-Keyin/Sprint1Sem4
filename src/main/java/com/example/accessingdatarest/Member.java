package com.example.accessingdatarest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

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
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startOfMembership;
    @Column
    private int durationOfMembership;
    @Column
    private int currentNumTournaments;
    @Column
    private int pastNumTournaments;
    @Column
    private int futureNumTournaments;
    @OneToOne
    @JoinColumn(name="membershipType")
    private MembershipType membershipType;

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType membershipType) {
        this.membershipType = membershipType;
    }

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

    public int getCurrentNumTournaments() {
        return currentNumTournaments;
    }

    public void setCurrentNumTournaments(int currentNumTournaments) {
        this.currentNumTournaments = currentNumTournaments;
    }
    public int getDurationOfMembership() {
        return durationOfMembership;
    }

    public void setDurationOfMembership(int durationOfMembership) {
        this.durationOfMembership = durationOfMembership;
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