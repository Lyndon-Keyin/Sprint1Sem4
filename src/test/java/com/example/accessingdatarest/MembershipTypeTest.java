package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MembershipTypeTest {
    @Test
    void testConstructor() {
        MembershipType actualMembershipType = new MembershipType();
        actualMembershipType.setMembershipType("Membership Type");
        assertEquals("Membership Type", actualMembershipType.getMembershipType());
    }

    @Test
    void testConstructor2() {
        assertEquals("Membership Type", (new MembershipType(123L, "Membership Type")).getMembershipType());
    }
}

