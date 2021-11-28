package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.CurrentTournamentsRepository;
import com.example.accessingdatarest.CurrentTournaments;
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

@ContextConfiguration(classes = {CurrentTournamentsController.class})
@ExtendWith(SpringExtension.class)
class CurrentTournamentsControllerTest {
    @Autowired
    private CurrentTournamentsController currentTournamentsController;

    @MockBean
    private CurrentTournamentsRepository currentTournamentsRepository;

    @Test
    void testDeleteTournament() throws Exception {
        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);
        Optional<CurrentTournaments> ofResult = Optional.<CurrentTournaments>of(currentTournaments);
        doNothing().when(this.currentTournamentsRepository).delete((CurrentTournaments) any());
        when(this.currentTournamentsRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteCurrentTournaments/{id}",
                123L);
        MockMvcBuilders.standaloneSetup(this.currentTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted user with the id: 123"));
    }

    @Test
    void testSave() throws Exception {
        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);
        when(this.currentTournamentsRepository.save((CurrentTournaments) any())).thenReturn(currentTournaments);

        CurrentTournaments currentTournaments1 = new CurrentTournaments();
        currentTournaments1.setLocation("Location");
        currentTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setEntryFee(1);
        currentTournaments1.setParticipatingMembers("Participating Members");
        currentTournaments1.setFinalStandings("Final Standings");
        currentTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setCashPrize(1);
        String content = (new ObjectMapper()).writeValueAsString(currentTournaments1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveCurrentTournaments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.currentTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Saved "));
    }

    @Test
    void testFindByParticipationMembers() throws Exception {
        when(this.currentTournamentsRepository.findByParticipatingMembers((String) any()))
                .thenReturn(new ArrayList<CurrentTournaments>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/getTour")
                .param("participatingMembers", "foo");
        MockMvcBuilders.standaloneSetup(this.currentTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testUpdateTournament() throws Exception {
        CurrentTournaments currentTournaments = new CurrentTournaments();
        currentTournaments.setLocation("Location");
        currentTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setEntryFee(1);
        currentTournaments.setParticipatingMembers("Participating Members");
        currentTournaments.setFinalStandings("Final Standings");
        currentTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments.setCashPrize(1);
        Optional<CurrentTournaments> ofResult = Optional.<CurrentTournaments>of(currentTournaments);

        CurrentTournaments currentTournaments1 = new CurrentTournaments();
        currentTournaments1.setLocation("Location");
        currentTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setEntryFee(1);
        currentTournaments1.setParticipatingMembers("Participating Members");
        currentTournaments1.setFinalStandings("Final Standings");
        currentTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments1.setCashPrize(1);
        when(this.currentTournamentsRepository.save((CurrentTournaments) any())).thenReturn(currentTournaments1);
        when(this.currentTournamentsRepository.findById((Long) any())).thenReturn(ofResult);

        CurrentTournaments currentTournaments2 = new CurrentTournaments();
        currentTournaments2.setLocation("Location");
        currentTournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        currentTournaments2.setEntryFee(1);
        currentTournaments2.setParticipatingMembers("Participating Members");
        currentTournaments2.setFinalStandings("Final Standings");
        currentTournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        currentTournaments2.setCashPrize(1);
        String content = (new ObjectMapper()).writeValueAsString(currentTournaments2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateCurrentTournaments/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.currentTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("updated..."));
    }
}

