package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;
import java.util.HashSet;

import org.junit.jupiter.api.Test;

class MembershipTypeTest {
    @Test
    void testConstructor() {
        MembershipType actualMembershipType = new MembershipType();
        actualMembershipType.setId(123L);
        MembershipType membershipType = new MembershipType();
        membershipType.setId(123L);
        Member member = new Member();
     //   membershipType.setMember(member);
        membershipType.setMembership_type("Membership type");
        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setDurationOfMembership(1);
        member1.setId(123L);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
     //   member1.setMembershipTypeID(membershipType);
        member1.setTournaments(new HashSet<Tournaments>());
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);
        MembershipType membershipType1 = new MembershipType();
        membershipType1.setId(123L);
     //   membershipType1.setMember(member1);
        membershipType1.setMembership_type("Membership type");
        Member member2 = new Member();
        member2.setLastName("Doe");
        member2.setEmail("jane.doe@example.org");
        member2.setDurationOfMembership(1);
        member2.setId(123L);
        member2.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member2.setMembershipTypeID(membershipType1);
        member2.setTournaments(new HashSet<Tournaments>());
        member2.setAddress("42 Main St");
        member2.setFirstName("Jane");
        member2.setPhone(1);
      //  actualMembershipType.setMember(member2);
        actualMembershipType.setMembership_type("Membership type");
        assertEquals(123L, actualMembershipType.getId());
      //  Member member3 = actualMembershipType.getMember();
     //   MembershipType membershipTypeID = member3.getMembershipTypeID();
     //   assertEquals(123L, membershipTypeID.getId());
      //  Member member4 = membershipTypeID.getMember();
      //  MembershipType membershipTypeID1 = member4.getMembershipTypeID();
       // assertEquals(123L, membershipTypeID1.getId());
       // assertSame(member2, member3);
       // assertSame(member1, member4);
      //  assertSame(member, membershipTypeID1.getMember());
        assertEquals("Membership type", actualMembershipType.getMembership_type());
       // assertEquals("Membership type", membershipTypeID.getMembership_type());
       // assertEquals("Membership type", membershipTypeID1.getMembership_type());
    }

//    @Test
//    void testConstructor2() {
//        Member member = new Member();
//        MembershipType actualMembershipType = new MembershipType(123L, "Membership type", member);
//
//        assertEquals(123L, actualMembershipType.getId());
//        assertEquals("Membership type", actualMembershipType.getMembership_type());
       // assertSame(member, actualMembershipType.getMember());
    }
//}

