package com.example.accessingdatarest;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Tournaments extends Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
    private String location;
    @Column
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
