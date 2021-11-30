package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class MemberTest {
    @Test
    void testConstructor() {
        Member actualMember = new Member();
        actualMember.setAddress("42 Main St");
        actualMember.setDurationOfMembership(1);
        actualMember.setEmail("jane.doe@example.org");
        actualMember.setFirstName("Jane");
        actualMember.setId(123L);
        actualMember.setLastName("Doe");
        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setDurationOfMembership(1);
        member.setId(123L);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        member.setStartOfMembership(ofEpochDayResult);
        MembershipType membershipType = new MembershipType();
      //  member.setMembershipTypeID(membershipType);
        HashSet<Tournaments> tournamentsSet = new HashSet<Tournaments>();
        member.setTournaments(tournamentsSet);
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);
        MembershipType membershipType1 = new MembershipType();
        membershipType1.setId(123L);
     //   membershipType1.setMember(member);
        membershipType1.setMembership_type("Membership type");
        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setDurationOfMembership(1);
        member1.setId(123L);
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        member1.setStartOfMembership(ofEpochDayResult1);
      //  member1.setMembershipTypeID(membershipType1);
        HashSet<Tournaments> tournamentsSet1 = new HashSet<Tournaments>();
        member1.setTournaments(tournamentsSet1);
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);
        MembershipType membershipType2 = new MembershipType();
        membershipType2.setId(123L);
     //   membershipType2.setMember(member1);
        membershipType2.setMembership_type("Membership type");
      //  actualMember.setMembershipTypeID(membershipType2);
        actualMember.setPhone(1);
        LocalDate ofEpochDayResult2 = LocalDate.ofEpochDay(1L);
        actualMember.setStartOfMembership(ofEpochDayResult2);
        HashSet<Tournaments> tournamentsSet2 = new HashSet<Tournaments>();
        actualMember.setTournaments(tournamentsSet2);
        assertEquals("42 Main St", actualMember.getAddress());
      //  MembershipType membershipTypeID = actualMember.getMembershipTypeID();
    //    Member member2 = membershipTypeID.getMember();
     //   assertEquals("42 Main St", member2.getAddress());
      //  MembershipType membershipTypeID1 = member2.getMembershipTypeID();
    //    Member member3 = membershipTypeID1.getMember();
     //   assertEquals("42 Main St", member3.getAddress());
        assertEquals(1, actualMember.getDurationOfMembership());
     //   assertEquals(1, member2.getDurationOfMembership());
     //   assertEquals(1, member3.getDurationOfMembership());
        assertEquals("jane.doe@example.org", actualMember.getEmail());
     //   assertEquals("jane.doe@example.org", member2.getEmail());
    //    assertEquals("jane.doe@example.org", member3.getEmail());
        assertEquals("Jane", actualMember.getFirstName());
     //   assertEquals("Jane", member2.getFirstName());
    //    assertEquals("Jane", member3.getFirstName());
        assertEquals(123L, actualMember.getId());
      //  assertEquals(123L, member2.getId());
     //   assertEquals(123L, member3.getId());
        assertEquals("Doe", actualMember.getLastName());
     //   assertEquals("Doe", member2.getLastName());
     //   assertEquals("Doe", member3.getLastName());
       // assertSame(membershipType2, membershipTypeID);
      //  assertSame(membershipType1, membershipTypeID1);
      //  assertSame(membershipType, member3.getMembershipTypeID());
        assertEquals(1, actualMember.getPhone());
      //  assertEquals(1, member2.getPhone());
     //   assertEquals(1, member3.getPhone());
        assertSame(ofEpochDayResult2, actualMember.getStartOfMembership());
      //  assertSame(ofEpochDayResult1, member2.getStartOfMembership());
     //   assertSame(ofEpochDayResult, member3.getStartOfMembership());
        assertSame(tournamentsSet2, actualMember.getTournaments());
   //     assertSame(tournamentsSet1, member2.getTournaments());
     //   assertSame(tournamentsSet, member3.getTournaments());
    }

    @Test
    void testConstructor2() {
        LocalDate startOfMembership = LocalDate.ofEpochDay(1L);
        HashSet<Tournaments> Tournaments = new HashSet<Tournaments>();
        MembershipType membershipType = new MembershipType();
        Member actualMember = new Member(123L, "Jane", "Doe", "42 Main St", "jane.doe@example.org", 1, startOfMembership, 1,
                Tournaments, membershipType);

        assertEquals("42 Main St", actualMember.getAddress());
        assertTrue(actualMember.getTournaments().isEmpty());
        assertEquals("1970-01-02", actualMember.getStartOfMembership().toString());
        assertEquals(1, actualMember.getPhone());
     //   assertSame(membershipType, actualMember.getMembershipTypeID());
        assertEquals("Doe", actualMember.getLastName());
        assertEquals(1, actualMember.getDurationOfMembership());
        assertEquals("Jane", actualMember.getFirstName());
        assertEquals(123L, actualMember.getId());
        assertEquals("jane.doe@example.org", actualMember.getEmail());
    }
}

