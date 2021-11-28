package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.MemberRepository;
import com.example.Repositories.MembershipTypeRepository;
import com.example.accessingdatarest.CurrentTournaments;
import com.example.accessingdatarest.FutureTournaments;
import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.MembershipType;
import com.example.accessingdatarest.PastTournaments;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.ArrayList;
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
    void testDeleteTournament() throws Exception {
        FutureTournaments futureTournaments = new FutureTournaments();
        futureTournaments.setLocation("Location");
        futureTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setEntryFee(1);
        futureTournaments.setParticipatingMembers("Participating Members");
        futureTournaments.setFinalStandings("Final Standings");
        futureTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setCashPrize(1);

        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);

        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipType("Membership Type");

        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);

        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setFutureNumTournamentsList(futureTournaments);
        member.setDurationOfMembership(1);
        member.setPastNumTournamentsList(pastTournaments);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member.setMembershipType(membershipType);
        member.setCurrentNumTournaments(currentTournaments);
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);
        Optional<Member> ofResult = Optional.<Member>of(member);
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
    void testFindByCurrentNumTournaments() throws Exception {
        when(this.memberRepository.findByCurrentNumTournaments(anyInt())).thenReturn(new ArrayList<Member>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/current");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("currentNumTournaments", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindByPastNumTournaments() throws Exception {
        when(this.memberRepository.findByPastNumTournaments(anyInt())).thenReturn(new ArrayList<Member>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/past");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("pastNumTournaments", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(this.memberController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testFindByFutureNumTournaments() throws Exception {
        when(this.memberRepository.findByFutureNumTournaments(anyInt())).thenReturn(new ArrayList<Member>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/future");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("futureNumTournaments", String.valueOf(1));
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
        FutureTournaments futureTournaments = new FutureTournaments();
        futureTournaments.setLocation("Location");
        futureTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setEntryFee(1);
        futureTournaments.setParticipatingMembers("Participating Members");
        futureTournaments.setFinalStandings("Final Standings");
        futureTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setCashPrize(1);

        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);

        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipType("Membership Type");

        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);

        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setFutureNumTournamentsList(futureTournaments);
        member.setDurationOfMembership(1);
        member.setPastNumTournamentsList(pastTournaments);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member.setMembershipType(membershipType);
        member.setCurrentNumTournaments(currentTournaments);
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);
        when(this.memberRepository.save((Member) any())).thenReturn(member);

        FutureTournaments futureTournaments1 = new FutureTournaments();
        futureTournaments1.setLocation("Location");
        futureTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setEntryFee(1);
        futureTournaments1.setParticipatingMembers("Participating Members");
        futureTournaments1.setFinalStandings("Final Standings");
        futureTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setCashPrize(1);

        PastTournaments pastTournaments1 = new PastTournaments();
        pastTournaments1.setLocation("Location");
        pastTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setEntryFee(1);
        pastTournaments1.setParticipatingMembers("Participating Members");
        pastTournaments1.setFinalStandings("Final Standings");
        pastTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setCashPrize(1);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setMembershipType("Membership Type");

        CurrentTournaments currentTournaments1 = new CurrentTournaments();
        currentTournaments1.setLocation("Location");
        currentTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setEntryFee(1);
        currentTournaments1.setParticipatingMembers("Participating Members");
        currentTournaments1.setFinalStandings("Final Standings");
        currentTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setCashPrize(1);

        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setFutureNumTournamentsList(futureTournaments1);
        member1.setDurationOfMembership(1);
        member1.setPastNumTournamentsList(pastTournaments1);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member1.setMembershipType(membershipType1);
        member1.setCurrentNumTournaments(currentTournaments1);
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);
        String content = (new ObjectMapper()).writeValueAsString(member1);
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
        FutureTournaments futureTournaments = new FutureTournaments();
        futureTournaments.setLocation("Location");
        futureTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setEntryFee(1);
        futureTournaments.setParticipatingMembers("Participating Members");
        futureTournaments.setFinalStandings("Final Standings");
        futureTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setCashPrize(1);

        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);

        MembershipType membershipType = new MembershipType();
        membershipType.setMembershipType("Membership Type");

        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);

        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setFutureNumTournamentsList(futureTournaments);
        member.setDurationOfMembership(1);
        member.setPastNumTournamentsList(pastTournaments);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member.setMembershipType(membershipType);
        member.setCurrentNumTournaments(currentTournaments);
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);
        Optional<Member> ofResult = Optional.<Member>of(member);

        FutureTournaments futureTournaments1 = new FutureTournaments();
        futureTournaments1.setLocation("Location");
        futureTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setEntryFee(1);
        futureTournaments1.setParticipatingMembers("Participating Members");
        futureTournaments1.setFinalStandings("Final Standings");
        futureTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setCashPrize(1);

        PastTournaments pastTournaments1 = new PastTournaments();
        pastTournaments1.setLocation("Location");
        pastTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setEntryFee(1);
        pastTournaments1.setParticipatingMembers("Participating Members");
        pastTournaments1.setFinalStandings("Final Standings");
        pastTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setCashPrize(1);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setMembershipType("Membership Type");

        CurrentTournaments currentTournaments1 = new CurrentTournaments();
        currentTournaments1.setLocation("Location");
        currentTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setEntryFee(1);
        currentTournaments1.setParticipatingMembers("Participating Members");
        currentTournaments1.setFinalStandings("Final Standings");
        currentTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setCashPrize(1);

        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setFutureNumTournamentsList(futureTournaments1);
        member1.setDurationOfMembership(1);
        member1.setPastNumTournamentsList(pastTournaments1);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member1.setMembershipType(membershipType1);
        member1.setCurrentNumTournaments(currentTournaments1);
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);
        when(this.memberRepository.save((Member) any())).thenReturn(member1);
        when(this.memberRepository.findById((Long) any())).thenReturn(ofResult);

        FutureTournaments futureTournaments2 = new FutureTournaments();
        futureTournaments2.setLocation("Location");
        futureTournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments2.setEntryFee(1);
        futureTournaments2.setParticipatingMembers("Participating Members");
        futureTournaments2.setFinalStandings("Final Standings");
        futureTournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments2.setCashPrize(1);

        PastTournaments pastTournaments2 = new PastTournaments();
        pastTournaments2.setLocation("Location");
        pastTournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments2.setEntryFee(1);
        pastTournaments2.setParticipatingMembers("Participating Members");
        pastTournaments2.setFinalStandings("Final Standings");
        pastTournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments2.setCashPrize(1);

        MembershipType membershipType2 = new MembershipType();
        membershipType2.setMembershipType("Membership Type");

        CurrentTournaments currentTournaments2 = new CurrentTournaments();
        currentTournaments2.setLocation("Location");
        currentTournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments2.setEntryFee(1);
        currentTournaments2.setParticipatingMembers("Participating Members");
        currentTournaments2.setFinalStandings("Final Standings");
        currentTournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments2.setCashPrize(1);

        Member member2 = new Member();
        member2.setLastName("Doe");
        member2.setEmail("jane.doe@example.org");
        member2.setFutureNumTournamentsList(futureTournaments2);
        member2.setDurationOfMembership(1);
        member2.setPastNumTournamentsList(pastTournaments2);
        member2.setStartOfMembership(LocalDate.ofEpochDay(1L));
        member2.setMembershipType(membershipType2);
        member2.setCurrentNumTournaments(currentTournaments2);
        member2.setAddress("42 Main St");
        member2.setFirstName("Jane");
        member2.setPhone(1);
        String content = (new ObjectMapper()).writeValueAsString(member2);
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
                                "{\"firstName\":\"Jane\",\"lastName\":\"Doe\",\"address\":\"42 Main St\",\"email\":\"jane.doe@example.org\",\"phone\":1"
                                        + ",\"startOfMembership\":\"02/01/1970\",\"durationOfMembership\":1,\"membershipType\":{\"membershipType\":\"Membership"
                                        + " Type\"},\"currentNumTournamentsList\":{\"startDate\":\"02/01/1970\",\"endDate\":\"02/01/1970\",\"location\":"
                                        + "\"Location\",\"entryFee\":1,\"cashPrize\":1,\"participatingMembers\":\"Participating Members\",\"finalStandings\":\"Final"
                                        + " Standings\"},\"pastNumTournamentsList\":null,\"futureNumTournamentsList\":{\"startDate\":\"02/01/1970\",\"endDate"
                                        + "\":\"02/01/1970\",\"location\":\"Location\",\"entryFee\":1,\"cashPrize\":1,\"participatingMembers\":\"Participating"
                                        + " Members\",\"finalStandings\":\"Final Standings\"}}"));
    }
}

