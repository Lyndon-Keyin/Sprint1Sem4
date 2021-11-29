package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.MembershipTypeRepository;
import com.example.accessingdatarest.MembershipType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {MembershipTypeController.class})
@ExtendWith(SpringExtension.class)
class MembershipTypeControllerTest {
    @Autowired
    private MembershipTypeController membershipTypeController;

    @MockBean
    private MembershipTypeRepository membershipTypeRepository;

    @Test
    void testDeleteTournament() throws Exception {
        MembershipType membershipType = new MembershipType();
        membershipType.setMembership_type("Membership Type");
        Optional<MembershipType> ofResult = Optional.<MembershipType>of(membershipType);
        doNothing().when(this.membershipTypeRepository).delete((MembershipType) any());
        when(this.membershipTypeRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteMembershipType/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.membershipTypeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted user with the id: 123"));
    }

    @Test
    void testSaveMembershipType() throws Exception {
        MembershipType membershipType = new MembershipType();
        membershipType.setMembership_type("Membership Type");
        when(this.membershipTypeRepository.save((MembershipType) any())).thenReturn(membershipType);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setMembership_type("Membership Type");
        String content = (new ObjectMapper()).writeValueAsString(membershipType1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveMembershipType")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.membershipTypeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Saved MembershipType"));
    }

    @Test
    void testUpdateMembershipType() throws Exception {
        MembershipType membershipType = new MembershipType();
        membershipType.setMembership_type("Membership Type");
        Optional<MembershipType> ofResult = Optional.<MembershipType>of(membershipType);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setMembership_type("Membership Type");
        when(this.membershipTypeRepository.save((MembershipType) any())).thenReturn(membershipType1);
        when(this.membershipTypeRepository.findById((Long) any())).thenReturn(ofResult);

        MembershipType membershipType2 = new MembershipType();
        membershipType2.setMembership_type("Membership Type");
        String content = (new ObjectMapper()).writeValueAsString(membershipType2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateMembershipType/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.membershipTypeController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("updated membership Type"));
    }
}

