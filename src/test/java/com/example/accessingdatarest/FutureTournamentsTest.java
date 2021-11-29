package com.example.accessingdatarest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class FutureTournamentsTest {
    @Test
    void testConstructor() {
        FutureTournaments actualFutureTournaments = new FutureTournaments();
        actualFutureTournaments.setCashPrize(1);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        actualFutureTournaments.setEndDate(ofEpochDayResult);
        actualFutureTournaments.setEntryFee(1);
        actualFutureTournaments.setFinalStandings("Final Standings");
        actualFutureTournaments.setLocation("Location");
        actualFutureTournaments.setParticipatingMembers("Participating Members");
        LocalDate ofEpochDayResult1 = LocalDate.ofEpochDay(1L);
        actualFutureTournaments.setStartDate(ofEpochDayResult1);
        assertEquals(1, actualFutureTournaments.getCashPrize());
        assertSame(ofEpochDayResult, actualFutureTournaments.getEndDate());
        assertEquals(1, actualFutureTournaments.getEntryFee());
        assertEquals("Final Standings", actualFutureTournaments.getFinalStandings());
        assertEquals("Location", actualFutureTournaments.getLocation());
        assertEquals("Participating Members", actualFutureTournaments.getParticipatingMembers());
        assertSame(ofEpochDayResult1, actualFutureTournaments.getStartDate());
    }


}

