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
        actualMember.setFutureNumTournamentsList(futureTournaments);
        actualMember.setLastName("Doe");
        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipType("Membership Type");
        actualMember.setMembershipType(membershipType);
        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);
        actualMember.setPastNumTournamentsList(pastTournaments);
        actualMember.setPhone(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualMember.setStartOfMembership(ofEpochDayResult);
        assertEquals("42 Main St", actualMember.getAddress());
        assertSame(currentTournaments, actualMember.getCurrentNumTournamentsList());
        assertEquals(1, actualMember.getDurationOfMembership());
        assertEquals("jane.doe@example.org", actualMember.getEmail());
        assertEquals("Jane", actualMember.getFirstName());
        assertSame(futureTournaments, actualMember.getFutureNumTournamentsList());
        assertEquals("Doe", actualMember.getLastName());
        assertSame(membershipType, actualMember.getMembershipType());
        assertNull(actualMember.getPastNumTournamentsList());
        assertEquals(1, actualMember.getPhone());
        assertSame(ofEpochDayResult, actualMember.getStartOfMembership());
    }

    @Test
    void testConstructor2() {
        LocalDate startOfMembership = LocalDate.ofEpochDay(1L);
        CurrentTournaments currentNumTournaments = new CurrentTournaments();
        PastTournaments pastTournaments = new PastTournaments();
        FutureTournaments futureNumTournaments = new FutureTournaments();
        Member actualMember = new Member("Jane", "Doe", "42 Main St", "jane.doe@example.org", 1, 1, startOfMembership,
                currentNumTournaments, pastTournaments, futureNumTournaments, new MembershipType());
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
        actualMember.setFutureNumTournamentsList(futureTournaments);
        actualMember.setLastName("Doe");
        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipType("Membership Type");
        actualMember.setMembershipType(membershipType);
        PastTournaments pastTournaments1 = new PastTournaments();
        pastTournaments1.setLocation("Location");
        pastTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setEntryFee(1);
        pastTournaments1.setParticipatingMembers("Participating Members");
        pastTournaments1.setFinalStandings("Final Standings");
        pastTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setCashPrize(1);
        actualMember.setPastNumTournamentsList(pastTournaments1);
        actualMember.setPhone(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualMember.setStartOfMembership(ofEpochDayResult);
        assertEquals("42 Main St", actualMember.getAddress());
        assertSame(currentTournaments, actualMember.getCurrentNumTournamentsList());
        assertEquals(1, actualMember.getDurationOfMembership());
        assertEquals("jane.doe@example.org", actualMember.getEmail());
        assertEquals("Jane", actualMember.getFirstName());
        assertSame(futureTournaments, actualMember.getFutureNumTournamentsList());
        assertEquals("Doe", actualMember.getLastName());
        assertSame(membershipType, actualMember.getMembershipType());
        assertSame(pastTournaments, actualMember.getPastNumTournamentsList());
        assertEquals(1, actualMember.getPhone());
        assertSame(ofEpochDayResult, actualMember.getStartOfMembership());
    }
}

