package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void testConstructor() {
        Member actualMember = new Member();
        actualMember.setAddress("42 Main St");
        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);
        actualMember.setCurrentNumTournaments(currentTournaments);
        actualMember.setDurationOfMembership(1);
        actualMember.setEmail("jane.doe@example.org");
        actualMember.setFirstName("Jane");
        FutureTournaments futureTournaments = new FutureTournaments();
        futureTournaments.setLocation("Location");
        futureTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setEntryFee(1);
        futureTournaments.setParticipatingMembers("Participating Members");
        futureTournaments.setFinalStandings("Final Standings");
        futureTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setCashPrize(1);
        actualMember.setFutureNumTournaments(futureTournaments);
        actualMember.setLastName("Doe");
        MembershipType membershipType = new MembershipType();
        membershipType.setMembership_type("Membership Type");
        actualMember.setMembership_type(membershipType);
        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);
        actualMember.setPastNumTournaments(pastTournaments);
        actualMember.setPhone(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualMember.setStartOfMembership(ofEpochDayResult);
        assertEquals("42 Main St", actualMember.getAddress());
        assertSame(currentTournaments, actualMember.getCurrentNumTournaments());
        assertEquals(1, actualMember.getDurationOfMembership());
        assertEquals("jane.doe@example.org", actualMember.getEmail());
        assertEquals("Jane", actualMember.getFirstName());
        assertSame(futureTournaments, actualMember.getFutureNumTournaments());
        assertEquals("Doe", actualMember.getLastName());
        assertSame(membershipType, actualMember.getMembership_type());
        assertNull(actualMember.getPastNumTournaments());
        assertEquals(1, actualMember.getPhone());
        assertSame(ofEpochDayResult, actualMember.getStartOfMembership());
    }


}

