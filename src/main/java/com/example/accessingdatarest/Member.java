package com.example.accessingdatarest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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


    @ManyToOne
    @JoinColumn(name="currentTournament")
    private CurrentTournaments currentNumTournaments;

    @ManyToOne
    @JoinColumn(name="pastTournament")
    private PastTournaments pastNumTournaments;

    @ManyToOne
    @JoinColumn(name="futureTournament")
    private FutureTournaments futureNumTournaments;


    @OneToOne
    @JoinColumn(name="membershipType")
    private MembershipType membershipType;

   public Member(){

   }

    public Member(
            String firstName,
            String lastName,
            String address,
            String email,
            int phone,
            int durationOfMembership,
            LocalDate startOfMembership,
            CurrentTournaments currentNumTournaments,
            PastTournaments pastNumTournaments,
            FutureTournaments futureNumTournaments,
            MembershipType membershipType )
    {
        this.firstName=firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.durationOfMembership = durationOfMembership;
        this.startOfMembership=startOfMembership;
        this.currentNumTournaments=currentNumTournaments;
        this.pastNumTournaments=pastNumTournaments;
        this.futureNumTournaments = futureNumTournaments;
        this.membershipType=membershipType;
    }

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

    public CurrentTournaments getCurrentNumTournamentsList() {
        return currentNumTournaments;
    }

    public void setCurrentNumTournaments(CurrentTournaments currentNumTournamentsList) {
        this.currentNumTournaments = currentNumTournamentsList;
    }

    public PastTournaments getPastNumTournamentsList() {
        return pastNumTournaments;
    }

    public void setPastNumTournamentsList(PastTournaments pastNumTournamentsList) {
        this.pastNumTournaments = pastNumTournaments;
    }

    public FutureTournaments getFutureNumTournamentsList() {
        return futureNumTournaments;
    }

    public void setFutureNumTournamentsList(FutureTournaments futureNumTournamentsList) {
        this.futureNumTournaments = futureNumTournamentsList;
    }

    public int getDurationOfMembership() {
        return durationOfMembership;
    }

    public void setDurationOfMembership(int durationOfMembership) {
        this.durationOfMembership = durationOfMembership;
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