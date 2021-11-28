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
public class FutureTournaments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;
    @Column
    @JsonFormat(pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
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

    public  FutureTournaments(){

    }
    public FutureTournaments(long id,
                              LocalDate startDate,
                              LocalDate endDate,
                              String location,
                              int entryFee,
                              int cashPrize,
                              String participatingMembers,
                              String finalStandings)
    {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.entryFee = entryFee;
        this.cashPrize = cashPrize;
        this.participatingMembers = participatingMembers;
        this.finalStandings = finalStandings;
    }



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

    public String getParticipatingMembers() {
        return participatingMembers;
    }

    public void setParticipatingMembers(String participatingMembers) {
        this.participatingMembers = participatingMembers;
    }

    public String getFinalStandings() {
        return finalStandings;
    }

    public void setFinalStandings(String finalStandings) {
        this.finalStandings = finalStandings;
    }


}
