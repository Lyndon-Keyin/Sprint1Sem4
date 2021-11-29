package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class PastTournamentsTest {
    @Test
    void testConstructor() {
        PastTournaments actualPastTournaments = new PastTournaments();
        actualPastTournaments.setCashPrize(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualPastTournaments.setEndDate(ofEpochDayResult);
        actualPastTournaments.setEntryFee(1);
        actualPastTournaments.setFinalStandings("Final Standings");
        actualPastTournaments.setLocation("Location");
        actualPastTournaments.setParticipatingMembers("Participating Members");
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualPastTournaments.setStartDate(ofEpochDayResult1);
        assertEquals(1, actualPastTournaments.getCashPrize());
        assertSame(ofEpochDayResult, actualPastTournaments.getEndDate());
        assertEquals(1, actualPastTournaments.getEntryFee());
        assertEquals("Final Standings", actualPastTournaments.getFinalStandings());
        assertEquals("Location", actualPastTournaments.getLocation());
        assertEquals("Participating Members", actualPastTournaments.getParticipatingMembers());
        assertSame(ofEpochDayResult1, actualPastTournaments.getStartDate());
    }


}

