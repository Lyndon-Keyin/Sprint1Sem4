package com.example.accessingdatarest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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
    @JoinColumn(name = "current_tournament")
    private CurrentTournaments currentNumTournaments;

    @ManyToOne
    @JoinColumn(name = "past_tournament")
    private PastTournaments pastNumTournaments;

    @ManyToOne
    @JoinColumn(name = "future_tournament")
    private FutureTournaments futureNumTournaments;


    @OneToOne
    @JoinColumn(name = "membership_type")
    private MembershipType membership_type;


}