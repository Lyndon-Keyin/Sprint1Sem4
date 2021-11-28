package com.example.restservice;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.example.Repositories.FutureTournamentsRepository;
import com.example.accessingdatarest.FutureTournaments;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
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

@ContextConfiguration(classes = {FutureTournamentsController.class})
@ExtendWith(SpringExtension.class)
class FutureTournamentsControllerTest {
    @Autowired
    private FutureTournamentsController futureTournamentsController;

    @MockBean
    private FutureTournamentsRepository futureTournamentsRepository;

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
        Optional<FutureTournaments> ofResult = Optional.<FutureTournaments>of(futureTournaments);
        doNothing().when(this.futureTournamentsRepository).delete((FutureTournaments) any());
        when(this.futureTournamentsRepository.findById((Long) any())).thenReturn(ofResult);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteFutureTournaments/{id}", 123L);
        MockMvcBuilders.standaloneSetup(this.futureTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Deleted user with the id: 123"));
    }

    @Test
    void testSave() throws Exception {
        FutureTournaments futureTournaments = new FutureTournaments();
        futureTournaments.setLocation("Location");
        futureTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setEntryFee(1);
        futureTournaments.setParticipatingMembers("Participating Members");
        futureTournaments.setFinalStandings("Final Standings");
        futureTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setCashPrize(1);
        when(this.futureTournamentsRepository.save((FutureTournaments) any())).thenReturn(futureTournaments);

        FutureTournaments futureTournaments1 = new FutureTournaments();
        futureTournaments1.setLocation("Location");
        futureTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setEntryFee(1);
        futureTournaments1.setParticipatingMembers("Participating Members");
        futureTournaments1.setFinalStandings("Final Standings");
        futureTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setCashPrize(1);
        String content = (new ObjectMapper()).writeValueAsString(futureTournaments1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/saveFutureTournaments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.futureTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Saved "));
    }

    @Test
    void testUpdateTournament() throws Exception {
        FutureTournaments futureTournaments = new FutureTournaments();
        futureTournaments.setLocation("Location");
        futureTournaments.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setEntryFee(1);
        futureTournaments.setParticipatingMembers("Participating Members");
        futureTournaments.setFinalStandings("Final Standings");
        futureTournaments.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments.setCashPrize(1);
        Optional<FutureTournaments> ofResult = Optional.<FutureTournaments>of(futureTournaments);

        FutureTournaments futureTournaments1 = new FutureTournaments();
        futureTournaments1.setLocation("Location");
        futureTournaments1.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setEntryFee(1);
        futureTournaments1.setParticipatingMembers("Participating Members");
        futureTournaments1.setFinalStandings("Final Standings");
        futureTournaments1.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments1.setCashPrize(1);
        when(this.futureTournamentsRepository.save((FutureTournaments) any())).thenReturn(futureTournaments1);
        when(this.futureTournamentsRepository.findById((Long) any())).thenReturn(ofResult);

        FutureTournaments futureTournaments2 = new FutureTournaments();
        futureTournaments2.setLocation("Location");
        futureTournaments2.setStartDate(LocalDate.ofEpochDay(1L));
        futureTournaments2.setEntryFee(1);
        futureTournaments2.setParticipatingMembers("Participating Members");
        futureTournaments2.setFinalStandings("Final Standings");
        futureTournaments2.setEndDate(LocalDate.ofEpochDay(1L));
        futureTournaments2.setCashPrize(1);
        String content = (new ObjectMapper()).writeValueAsString(futureTournaments2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.put("/updateFutureTournaments/{id}", 123L)
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.futureTournamentsController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("updated..."));
    }
}

