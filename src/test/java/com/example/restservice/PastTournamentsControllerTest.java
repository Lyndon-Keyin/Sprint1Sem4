package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.PastTournamentsRepository;
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

@ContextConfiguration(classes = {PastTournamentsController.class})
@ExtendWith(SpringExtension.class)
class PastTournamentsControllerTest {
    @Autowired
    private PastTournamentsController pastTournamentsController;

    @MockBean
    private PastTournamentsRepository pastTournamentsRepository;

    @Test
    void testDeleteTournament() throws Exception {
        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);
        Optional<PastTournaments> ofResult = Optional.<PastTournaments>of(pastTournaments);
        doNothing().when(this.pastTournamentsRepository).delete((PastTournaments) any());
        when(this.pastTournamentsRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deletePastTournaments/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.pastTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted user with the id: 123"));
    }

    @Test
    void testSave() throws Exception {
        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);
        when(this.pastTournamentsRepository.save((PastTournaments) any())).thenReturn(pastTournaments);

        PastTournaments pastTournaments1 = new PastTournaments();
        pastTournaments1.setLocation("Location");
        pastTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setEntryFee(1);
        pastTournaments1.setParticipatingMembers("Participating Members");
        pastTournaments1.setFinalStandings("Final Standings");
        pastTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setCashPrize(1);
        String content = (new ObjectMapper()).writeValueAsString(pastTournaments1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/savePastTournaments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.pastTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Saved "));
    }

    @Test
    void testFindByParticipationMembers() throws Exception {
        when(this.pastTournamentsRepository.findByParticipatingMembers((String) any()))
                .thenReturn(new ArrayList<PastTournaments>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getPastTour")
                .param("participatingMembers", "foo");
        MockMvcBuilders.standaloneSetup(this.pastTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdateTournament() throws Exception {
        PastTournaments pastTournaments = new PastTournaments();
        pastTournaments.setLocation("Location");
        pastTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setEntryFee(1);
        pastTournaments.setParticipatingMembers("Participating Members");
        pastTournaments.setFinalStandings("Final Standings");
        pastTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments.setCashPrize(1);
        Optional<PastTournaments> ofResult = Optional.<PastTournaments>of(pastTournaments);

        PastTournaments pastTournaments1 = new PastTournaments();
        pastTournaments1.setLocation("Location");
        pastTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setEntryFee(1);
        pastTournaments1.setParticipatingMembers("Participating Members");
        pastTournaments1.setFinalStandings("Final Standings");
        pastTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments1.setCashPrize(1);
        when(this.pastTournamentsRepository.save((PastTournaments) any())).thenReturn(pastTournaments1);
        when(this.pastTournamentsRepository.findById((Long) any())).thenReturn(ofResult);

        PastTournaments pastTournaments2 = new PastTournaments();
        pastTournaments2.setLocation("Location");
        pastTournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        pastTournaments2.setEntryFee(1);
        pastTournaments2.setParticipatingMembers("Participating Members");
        pastTournaments2.setFinalStandings("Final Standings");
        pastTournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        pastTournaments2.setCashPrize(1);
        String content = (new ObjectMapper()).writeValueAsString(pastTournaments2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updatePastTournaments/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.pastTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("updated..."));
    }
}

