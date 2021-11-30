package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.MemberRepository;
import com.example.Repositories.MembershipTypeRepository;
import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.MembershipType;
import com.example.accessingdatarest.Tournaments;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
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

@ContextConfiguration(classes = {MemberController.class})
@ExtendWith(SpringExtension.class)
class MemberControllerTest {
    @Autowired
    private MemberController memberController;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private MembershipTypeRepository membershipTypeRepository;

    @Test
    void testDeleteTournament() throws Exception {
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
        Optional<Member> ofResult = Optional.<Member>of(member1);
        doNothing().when(this.memberRepository).delete((Member) any());
        when(this.memberRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteMember/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted user with the id: 123"));
    }

    @Test
    void testFindByLastName() throws Exception {
        when(this.memberRepository.findByLastName((String) any())).thenReturn(new ArrayList<Member>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/members").param("lastname", "foo");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindByPhone() throws Exception {
        when(this.memberRepository.findByPhone(anyInt())).thenReturn(new ArrayList<Member>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/phone");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("phone", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/welcome");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Welcome to the CRUD App"));
    }

    @Test
    void testGetPage2() throws Exception {
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/welcome");
        getResult.contentType("Not all who wander are lost");
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Welcome to the CRUD App"));
    }

    @Test
    void testSaveMember() throws Exception {
        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setDurationOfMembership(1);
        member.setId(123L);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member.setMembershipTypeID(new MembershipType());
        member.setTournaments(new HashSet<Tournaments>());
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);

        MembershipType membershipType = new MembershipType();
        membershipType.setId(123L);
        membershipType.setMember(member);
        membershipType.setMembership_type("Membership type");

        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setDurationOfMembership(1);
        member1.setId(123L);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member1.setMembershipTypeID(membershipType);
        member1.setTournaments(new HashSet<Tournaments>());
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setId(123L);
        membershipType1.setMember(member1);
        membershipType1.setMembership_type("Membership type");

        Member member2 = new Member();
        member2.setLastName("Doe");
        member2.setEmail("jane.doe@example.org");
        member2.setDurationOfMembership(1);
        member2.setId(123L);
        member2.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member2.setMembershipTypeID(membershipType1);
        member2.setTournaments(new HashSet<Tournaments>());
        member2.setAddress("42 Main St");
        member2.setFirstName("Jane");
        member2.setPhone(1);
        when(this.memberRepository.save((Member) any())).thenReturn(member2);

        Member member3 = new Member();
        member3.setLastName("Doe");
        member3.setEmail("jane.doe@example.org");
        member3.setDurationOfMembership(1);
        member3.setId(123L);
        member3.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member3.setMembershipTypeID(new MembershipType());
        member3.setTournaments(new HashSet<Tournaments>());
        member3.setAddress("42 Main St");
        member3.setFirstName("Jane");
        member3.setPhone(1);

        MembershipType membershipType2 = new MembershipType();
        membershipType2.setId(123L);
        membershipType2.setMember(member3);
        membershipType2.setMembership_type("Membership type");

        Member member4 = new Member();
        member4.setLastName("Doe");
        member4.setEmail("jane.doe@example.org");
        member4.setDurationOfMembership(1);
        member4.setId(123L);
        member4.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member4.setMembershipTypeID(membershipType2);
        member4.setTournaments(new HashSet<Tournaments>());
        member4.setAddress("42 Main St");
        member4.setFirstName("Jane");
        member4.setPhone(1);

        MembershipType membershipType3 = new MembershipType();
        membershipType3.setId(123L);
        membershipType3.setMember(member4);
        membershipType3.setMembership_type("Membership type");

        Member member5 = new Member();
        member5.setLastName("Doe");
        member5.setEmail("jane.doe@example.org");
        member5.setDurationOfMembership(1);
        member5.setId(123L);
        member5.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member5.setMembershipTypeID(membershipType3);
        member5.setTournaments(new HashSet<Tournaments>());
        member5.setAddress("42 Main St");
        member5.setFirstName("Jane");
        member5.setPhone(1);
        String content = (new ObjectMapper()).writeValueAsString(member5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveMember")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Saved Member"));
    }

    @Test
    void testUpdateMember() throws Exception {
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
        Optional<Member> ofResult = Optional.<Member>of(member1);

        Member member2 = new Member();
        member2.setLastName("Doe");
        member2.setEmail("jane.doe@example.org");
        member2.setDurationOfMembership(1);
        member2.setId(123L);
        member2.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member2.setMembershipTypeID(new MembershipType());
        member2.setTournaments(new HashSet<Tournaments>());
        member2.setAddress("42 Main St");
        member2.setFirstName("Jane");
        member2.setPhone(1);

        MembershipType membershipType2 = new MembershipType();
        membershipType2.setId(123L);
        membershipType2.setMember(member2);
        membershipType2.setMembership_type("Membership type");

        Member member3 = new Member();
        member3.setLastName("Doe");
        member3.setEmail("jane.doe@example.org");
        member3.setDurationOfMembership(1);
        member3.setId(123L);
        member3.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member3.setMembershipTypeID(membershipType2);
        member3.setTournaments(new HashSet<Tournaments>());
        member3.setAddress("42 Main St");
        member3.setFirstName("Jane");
        member3.setPhone(1);

        MembershipType membershipType3 = new MembershipType();
        membershipType3.setId(123L);
        membershipType3.setMember(member3);
        membershipType3.setMembership_type("Membership type");

        Member member4 = new Member();
        member4.setLastName("Doe");
        member4.setEmail("jane.doe@example.org");
        member4.setDurationOfMembership(1);
        member4.setId(123L);
        member4.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member4.setMembershipTypeID(membershipType3);
        member4.setTournaments(new HashSet<Tournaments>());
        member4.setAddress("42 Main St");
        member4.setFirstName("Jane");
        member4.setPhone(1);
        when(this.memberRepository.save((Member) any())).thenReturn(member4);
        when(this.memberRepository.findById((Long) any())).thenReturn(ofResult);

        Member member5 = new Member();
        member5.setLastName("Doe");
        member5.setEmail("jane.doe@example.org");
        member5.setDurationOfMembership(1);
        member5.setId(123L);
        member5.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member5.setMembershipTypeID(new MembershipType());
        member5.setTournaments(new HashSet<Tournaments>());
        member5.setAddress("42 Main St");
        member5.setFirstName("Jane");
        member5.setPhone(1);

        MembershipType membershipType4 = new MembershipType();
        membershipType4.setId(123L);
        membershipType4.setMember(member5);
        membershipType4.setMembership_type("Membership type");

        Member member6 = new Member();
        member6.setLastName("Doe");
        member6.setEmail("jane.doe@example.org");
        member6.setDurationOfMembership(1);
        member6.setId(123L);
        member6.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member6.setMembershipTypeID(membershipType4);
        member6.setTournaments(new HashSet<Tournaments>());
        member6.setAddress("42 Main St");
        member6.setFirstName("Jane");
        member6.setPhone(1);

        MembershipType membershipType5 = new MembershipType();
        membershipType5.setId(123L);
        membershipType5.setMember(member6);
        membershipType5.setMembership_type("Membership type");

        Member member7 = new Member();
        member7.setLastName("Doe");
        member7.setEmail("jane.doe@example.org");
        member7.setDurationOfMembership(1);
        member7.setId(123L);
        member7.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member7.setMembershipTypeID(membershipType5);
        member7.setTournaments(new HashSet<Tournaments>());
        member7.setAddress("42 Main St");
        member7.setFirstName("Jane");
        member7.setPhone(1);
        String content = (new ObjectMapper()).writeValueAsString(member7);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateMember/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"address\":\"42 Main St\",\"email\":\"jane.doe@example.org\","
                                        + "\"phone\":1,\"startOfMembership\":\"02/01/1970\",\"durationOfMembership\":1,\"membershipTypeID\":{\"id\":123,"
                                        + "\"membership_type\":\"Membership type\",\"member\":{\"id\":123,\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"address\":\"42"
                                        + " Main St\",\"email\":\"jane.doe@example.org\",\"phone\":1,\"startOfMembership\":\"02/01/1970\",\"durationOfMembership"
                                        + "\":1,\"membershipTypeID\":{\"id\":123,\"membership_type\":\"Membership type\",\"member\":{\"id\":123,\"firstName\":"
                                        + "\"Jane\",\"lastName\":\"Doe\",\"address\":\"42 Main St\",\"email\":\"jane.doe@example.org\",\"phone\":1,\"startOfMembership"
                                        + "\":\"02/01/1970\",\"durationOfMembership\":1,\"membershipTypeID\":{\"id\":0,\"membership_type\":null,\"member\""
                                        + ":null},\"tournaments\":[]}},\"tournaments\":[]}},\"tournaments\":[]}"));
    }
}

