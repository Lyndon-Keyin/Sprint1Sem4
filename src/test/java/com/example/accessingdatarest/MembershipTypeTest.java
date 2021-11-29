package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class MembershipTypeTest {
    @Test
    void testConstructor() {
        MembershipType actualMembershipType = new MembershipType();
        actualMembershipType.setMembership_type("Membership Type");
        assertEquals("Membership Type", actualMembershipType.getMembership_type());
    }


}

