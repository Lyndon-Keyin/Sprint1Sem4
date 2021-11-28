package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class CurrentTournamentsTest {
    @Test
    void testConstructor() {
        CurrentTournaments actualCurrentTournaments = new CurrentTournaments();
        actualCurrentTournaments.setCashPrize(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualCurrentTournaments.setEndDate(ofEpochDayResult);
        actualCurrentTournaments.setEntryFee(1);
        actualCurrentTournaments.setFinalStandings("Final Standings");
        actualCurrentTournaments.setLocation("Location");
        actualCurrentTournaments.setParticipatingMembers("Participating Members");
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualCurrentTournaments.setStartDate(ofEpochDayResult1);
        assertEquals(1, actualCurrentTournaments.getCashPrize());
        assertSame(ofEpochDayResult, actualCurrentTournaments.getEndDate());
        assertEquals(1, actualCurrentTournaments.getEntryFee());
        assertEquals("Final Standings", actualCurrentTournaments.getFinalStandings());
        assertEquals("Location", actualCurrentTournaments.getLocation());
        assertEquals("Participating Members", actualCurrentTournaments.getParticipatingMembers());
        assertSame(ofEpochDayResult1, actualCurrentTournaments.getStartDate());
    }

    @Test
    void testConstructor2() {
        CurrentTournaments actualCurrentTournaments = new CurrentTournaments(123L, LocalDate.ofEpochDay(1L),
                LocalDate.ofEpochDay(1L), "Location", 1, 1, "Participating Members", "Final Standings");

        assertEquals(1, actualCurrentTournaments.getCashPrize());
        assertEquals("1970-01-02", actualCurrentTournaments.getStartDate().toString());
        assertEquals("Participating Members", actualCurrentTournaments.getParticipatingMembers());
        assertEquals("Location", actualCurrentTournaments.getLocation());
        assertEquals("Final Standings", actualCurrentTournaments.getFinalStandings());
        assertEquals(1, actualCurrentTournaments.getEntryFee());
        assertEquals("1970-01-02", actualCurrentTournaments.getEndDate().toString());
    }
}

