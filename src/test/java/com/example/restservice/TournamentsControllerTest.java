package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.TournamentsRepository;
import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.MembershipType;
import com.example.accessingdatarest.Tournaments;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
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

@ContextConfiguration(classes = {TournamentsController.class})
@ExtendWith(SpringExtension.class)
class TournamentsControllerTest {
    @Autowired
    private TournamentsController tournamentsController;

    @MockBean
    private TournamentsRepository tournamentsRepository;

    @Test
    void testDeleteTournament() throws Exception {
        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setDurationOfMembership(1);
        member.setId(123L);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member.setMembershipTypeID(new MembershipType());
        member.setTournaments(new HashSet<Tournaments>());
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);

        MembershipType membershipType = new MembershipType();
        membershipType.setId(123L);
      //  membershipType.setMember(member);
        membershipType.setMembership_type("Membership type");

        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setDurationOfMembership(1);
        member1.setId(123L);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member1.setMembershipTypeID(membershipType);
        member1.setTournaments(new HashSet<Tournaments>());
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);

        Tournaments tournaments = new Tournaments();
        tournaments.setLocation("Location");
        tournaments.setTournamentName("Tournament Name");
        tournaments.setStartDate(LocalDate.ofEpochDay(1L));
        tournaments.setEntryFee(1);
        tournaments.setFinalStandings("Final Standings");
        tournaments.setId(123L);
        tournaments.setEndDate(LocalDate.ofEpochDay(1L));
        tournaments.setCashPrize(1);
        tournaments.setMember(member1);
        Optional<Tournaments> ofResult = Optional.<Tournaments>of(tournaments);
        doNothing().when(this.tournamentsRepository).delete((Tournaments) any());
        when(this.tournamentsRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteTournaments/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.tournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted user with the id: 123"));
    }

    @Test
    void testSave() throws Exception {
        MembershipType membershipType = new MembershipType();
        membershipType.setId(123L);
      //  membershipType.setMember(new Member());
        membershipType.setMembership_type("Membership type");

        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setDurationOfMembership(1);
        member.setId(123L);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member.setMembershipTypeID(membershipType);
        member.setTournaments(new HashSet<Tournaments>());
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setId(123L);
    //    membershipType1.setMember(member);
        membershipType1.setMembership_type("Membership type");

        Member member1 = new Member();
        member1.setLastName("Doe");
        member1.setEmail("jane.doe@example.org");
        member1.setDurationOfMembership(1);
        member1.setId(123L);
        member1.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member1.setMembershipTypeID(membershipType1);
        member1.setTournaments(new HashSet<Tournaments>());
        member1.setAddress("42 Main St");
        member1.setFirstName("Jane");
        member1.setPhone(1);

        Tournaments tournaments = new Tournaments();
        tournaments.setLocation("Location");
        tournaments.setTournamentName("Tournament Name");
        tournaments.setStartDate(LocalDate.ofEpochDay(1L));
        tournaments.setEntryFee(1);
        tournaments.setFinalStandings("Final Standings");
        tournaments.setId(123L);
        tournaments.setEndDate(LocalDate.ofEpochDay(1L));
        tournaments.setCashPrize(1);
        tournaments.setMember(member1);
        when(this.tournamentsRepository.save((Tournaments) any())).thenReturn(tournaments);

        MembershipType membershipType2 = new MembershipType();
        membershipType2.setId(123L);
     //   membershipType2.setMember(new Member());
        membershipType2.setMembership_type("Membership type");

        Member member2 = new Member();
        member2.setLastName("Doe");
        member2.setEmail("jane.doe@example.org");
        member2.setDurationOfMembership(1);
        member2.setId(123L);
        member2.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member2.setMembershipTypeID(membershipType2);
        member2.setTournaments(new HashSet<Tournaments>());
        member2.setAddress("42 Main St");
        member2.setFirstName("Jane");
        member2.setPhone(1);

        MembershipType membershipType3 = new MembershipType();
        membershipType3.setId(123L);
     //   membershipType3.setMember(member2);
        membershipType3.setMembership_type("Membership type");

        Member member3 = new Member();
        member3.setLastName("Doe");
        member3.setEmail("jane.doe@example.org");
        member3.setDurationOfMembership(1);
        member3.setId(123L);
        member3.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member3.setMembershipTypeID(membershipType3);
        member3.setTournaments(new HashSet<Tournaments>());
        member3.setAddress("42 Main St");
        member3.setFirstName("Jane");
        member3.setPhone(1);

        Tournaments tournaments1 = new Tournaments();
        tournaments1.setLocation("Location");
        tournaments1.setTournamentName("Tournament Name");
        tournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        tournaments1.setEntryFee(1);
        tournaments1.setFinalStandings("Final Standings");
        tournaments1.setId(123L);
        tournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        tournaments1.setCashPrize(1);
        tournaments1.setMember(member3);
        String content = (new ObjectMapper()).writeValueAsString(tournaments1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveTournaments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Saved "));
    }

    @Test
    void testUpdateCurrentTournament() throws Exception {
        Member member = new Member();
        member.setLastName("Doe");
        member.setEmail("jane.doe@example.org");
        member.setDurationOfMembership(1);
        member.setId(123L);
        member.setStartOfMembership(LocalDate.ofEpochDay(1L));
     //   member.setMembershipTypeID(new MembershipType());
        member.setTournaments(new HashSet<Tournaments>());
        member.setAddress("42 Main St");
        member.setFirstName("Jane");
        member.setPhone(1);

        MembershipType membershipType = new MembershipType();
        membershipType.setId(123L);
    //    membershipType.setMember(member);
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

        Tournaments tournaments = new Tournaments();
        tournaments.setLocation("Location");
        tournaments.setTournamentName("Tournament Name");
        tournaments.setStartDate(LocalDate.ofEpochDay(1L));
        tournaments.setEntryFee(1);
        tournaments.setFinalStandings("Final Standings");
        tournaments.setId(123L);
        tournaments.setEndDate(LocalDate.ofEpochDay(1L));
        tournaments.setCashPrize(1);
        tournaments.setMember(member1);
        Optional<Tournaments> ofResult = Optional.<Tournaments>of(tournaments);

        MembershipType membershipType1 = new MembershipType();
        membershipType1.setId(123L);
     //  membershipType1.setMember(new Member());
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

        MembershipType membershipType2 = new MembershipType();
        membershipType2.setId(123L);
      //  membershipType2.setMember(member2);
        membershipType2.setMembership_type("Membership type");

        Member member3 = new Member();
        member3.setLastName("Doe");
        member3.setEmail("jane.doe@example.org");
        member3.setDurationOfMembership(1);
        member3.setId(123L);
        member3.setStartOfMembership(LocalDate.ofEpochDay(1L));
      ///  member3.setMembershipTypeID(membershipType2);
        member3.setTournaments(new HashSet<Tournaments>());
        member3.setAddress("42 Main St");
        member3.setFirstName("Jane");
        member3.setPhone(1);

        Tournaments tournaments1 = new Tournaments();
        tournaments1.setLocation("Location");
        tournaments1.setTournamentName("Tournament Name");
        tournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        tournaments1.setEntryFee(1);
        tournaments1.setFinalStandings("Final Standings");
        tournaments1.setId(123L);
        tournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        tournaments1.setCashPrize(1);
        tournaments1.setMember(member3);
        when(this.tournamentsRepository.save((Tournaments) any())).thenReturn(tournaments1);
        when(this.tournamentsRepository.findById((Long) any())).thenReturn(ofResult);

        MembershipType membershipType3 = new MembershipType();
        membershipType3.setId(123L);
      //  membershipType3.setMember(new Member());
        membershipType3.setMembership_type("Membership type");

        Member member4 = new Member();
        member4.setLastName("Doe");
        member4.setEmail("jane.doe@example.org");
        member4.setDurationOfMembership(1);
        member4.setId(123L);
        member4.setStartOfMembership(LocalDate.ofEpochDay(1L));
     //  member4.setMembershipTypeID(membershipType3);
        member4.setTournaments(new HashSet<Tournaments>());
        member4.setAddress("42 Main St");
        member4.setFirstName("Jane");
        member4.setPhone(1);

        MembershipType membershipType4 = new MembershipType();
        membershipType4.setId(123L);
     //   membershipType4.setMember(member4);
        membershipType4.setMembership_type("Membership type");

        Member member5 = new Member();
        member5.setLastName("Doe");
        member5.setEmail("jane.doe@example.org");
        member5.setDurationOfMembership(1);
        member5.setId(123L);
        member5.setStartOfMembership(LocalDate.ofEpochDay(1L));
      //  member5.setMembershipTypeID(membershipType4);
        member5.setTournaments(new HashSet<Tournaments>());
        member5.setAddress("42 Main St");
        member5.setFirstName("Jane");
        member5.setPhone(1);

        Tournaments tournaments2 = new Tournaments();
        tournaments2.setLocation("Location");
        tournaments2.setTournamentName("Tournament Name");
        tournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        tournaments2.setEntryFee(1);
        tournaments2.setFinalStandings("Final Standings");
        tournaments2.setId(123L);
        tournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        tournaments2.setCashPrize(1);
        tournaments2.setMember(member5);
        String content = (new ObjectMapper()).writeValueAsString(tournaments2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateTournaments/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.tournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("updated..."));
    }
}

