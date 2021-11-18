package com.example.accessingdatarest;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Tournaments extends Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private int entryFee;
    private int cashPrize;
    private String participatingMemebers;
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
        return participatingMemebers;
    }

    public void setParticipatingMemebers(String participatingMemebers) {
        this.participatingMemebers = participatingMemebers;
    }

    public String getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(String finalStandings) {
        this.finalStandings = finalStandings;
    }

}
