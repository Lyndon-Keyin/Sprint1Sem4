package com.example.accessingdatarest;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Tournaments extends Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "start_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm", iso = DateTimeFormat.ISO.DATE_TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDate startDate;
    @Column
    @JsonFormat (pattern = "YYYY-MM-DD")
    private LocalDate endDate;
    @Column
    private String location;
    @Column(name = "entry_fee")
    private int entryFee;
    @Column
    private int cashPrize;
    @Column
    private String participatingMembers;
    @Column
    private String finalStandings;


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(int entryFee) {
        this.entryFee = entryFee;
    }

    public int getCashPrize() {
        return cashPrize;
    }

    public void setCashPrize(int cashPrize) {
        this.cashPrize = cashPrize;
    }

    public String getParticipatingMemebers() {
        return participatingMembers;
    }

    public void setParticipatingMemebers(String participatingMemebers) {
        this.participatingMembers = participatingMemebers;
    }

    public String getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(String finalStandings) {
        this.finalStandings = finalStandings;
    }

}
