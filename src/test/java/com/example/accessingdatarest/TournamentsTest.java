package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class TournamentsTest {
    @Test
    void testConstructor() {
        Tournaments actualTournaments = new Tournaments();
        actualTournaments.setCashPrize(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualTournaments.setEndDate(ofEpochDayResult);
        actualTournaments.setEntryFee(1);
        actualTournaments.setFinalStandings("Final Standings");
        actualTournaments.setId(123L);
        actualTournaments.setLocation("Location");
        MembershipType membershipType = new MembershipType();
        membershipType.setId(123L);
        membershipType.setMember(new Member());
        membershipType.setMembership_type("Membership type");
        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setDurationOfMembership(1);
        member.setId(123L);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member.setMembershipTypeID(membershipType);
        member.setTournaments(new HashSet<Tournaments>());
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);
        MembershipType membershipType1 = new MembershipType();
        membershipType1.setId(123L);
        membershipType1.setMember(member);
        membershipType1.setMembership_type("Membership type");
        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setDurationOfMembership(1);
        member1.setId(123L);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member1.setMembershipTypeID(membershipType1);
        member1.setTournaments(new HashSet<Tournaments>());
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);
        actualTournaments.setMember(member1);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualTournaments.setStartDate(ofEpochDayResult1);
        actualTournaments.setTournamentName("Tournament Name");
        assertEquals(1, actualTournaments.getCashPrize());
        assertSame(ofEpochDayResult, actualTournaments.getEndDate());
        assertEquals(1, actualTournaments.getEntryFee());
        assertEquals("Final Standings", actualTournaments.getFinalStandings());
        assertEquals(123L, actualTournaments.getId());
        assertEquals("Location", actualTournaments.getLocation());
        assertSame(member1, actualTournaments.getMember());
        assertSame(ofEpochDayResult1, actualTournaments.getStartDate());
        assertEquals("Tournament Name", actualTournaments.getTournamentName());
    }

    @Test
    void testConstructor2() {
        LocalDate startDate = LocalDate.ofEpochDay(1L);
        LocalDate endDate = LocalDate.ofEpochDay(1L);
        Member member = new Member();
        Tournaments actualTournaments = new Tournaments(123L, startDate, endDate, "Location", 1, 1, "Final Standings",
                "Tournament Name", member);

        assertEquals(1, actualTournaments.getCashPrize());
        assertEquals("Tournament Name", actualTournaments.getTournamentName());
        assertEquals("1970-01-02", actualTournaments.getStartDate().toString());
        assertSame(member, actualTournaments.getMember());
        assertEquals("Location", actualTournaments.getLocation());
        assertEquals("1970-01-02", actualTournaments.getEndDate().toString());
        assertEquals("Final Standings", actualTournaments.getFinalStandings());
        assertEquals(123L, actualTournaments.getId());
        assertEquals(1, actualTournaments.getEntryFee());
    }
}

