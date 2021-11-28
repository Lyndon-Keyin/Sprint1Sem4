package com.example.restservice;

import com.example.accessingdatarest.CurrentTournaments;
import com.example.Repositories.CurrentTournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CurrentTournamentsController {

    @Autowired
    private CurrentTournamentsRepository currentTournamentsRepository;

    @GetMapping(value = "/allT")
    public Iterable<CurrentTournaments> getMembers(){
        return currentTournamentsRepository.findAll();
    }
    @GetMapping(value="/getTour")
    public ResponseEntity<List<CurrentTournaments>> findByParticipationMembers(@RequestParam String participatingMembers){
        try {
            List<CurrentTournaments> tournaments = new ArrayList<CurrentTournaments>();
            currentTournamentsRepository.findByParticipatingMembers(participatingMembers).forEach(tournaments::add);
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/saveCurrentTournaments")
    public String save(@RequestBody CurrentTournaments tournaments){
        currentTournamentsRepository.save(tournaments);
        return "Saved ";
    }

    @PutMapping(value = "/updateCurrentTournaments/{id}")
    public String updateTournament(@PathVariable long id, @RequestBody CurrentTournaments currentTournaments) throws Exception {
        try {
            CurrentTournaments updatedCurrentTournaments = currentTournamentsRepository.findById(id).get();
            updatedCurrentTournaments.setCashPrize(currentTournaments.getCashPrize());
            updatedCurrentTournaments.setEntryFee(currentTournaments.getEntryFee());
            updatedCurrentTournaments.setLocation(currentTournaments.getLocation());
            updatedCurrentTournaments.setFinalStandings(currentTournaments.getFinalStandings());
            updatedCurrentTournaments.setParticipatingMembers(currentTournaments.getParticipatingMembers());
            updatedCurrentTournaments.setStartDate(currentTournaments.getStartDate());
            updatedCurrentTournaments.setEndDate(currentTournaments.getEndDate());

            currentTournamentsRepository.save(updatedCurrentTournaments);
            return "updated...";
        }
        catch(Exception e){
            throw new Exception("The concept of a controller should be to make life easier...");
        }
    }


    @DeleteMapping(value="/deleteCurrentTournaments/{id}")
    public String deleteTournament(@PathVariable long id){
        CurrentTournaments deleteT = currentTournamentsRepository.findById(id).get();
        currentTournamentsRepository.delete(deleteT);
        return "Deleted user with the id: "+id;
    }
}
