package com.example.restservice;

import com.example.Repositories.PastTournamentsRepository;
import com.example.Repositories.PastTournamentsRepository;
import com.example.accessingdatarest.PastTournaments;
import com.example.accessingdatarest.PastTournaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PastTournamentsController {
    @Autowired
    private PastTournamentsRepository pastTournamentsRepository;

    @GetMapping(value = "/allPastTournaments")
    public Iterable<PastTournaments> getMembers(){
        return pastTournamentsRepository.findAll();
    }
    @GetMapping(value="/getPastTour")
    public ResponseEntity<List<PastTournaments>> findByParticipationMembers(@RequestParam String participatingMembers){
        try {
            List<PastTournaments> tournaments = new ArrayList<PastTournaments>();
            pastTournamentsRepository.findByParticipatingMembers(participatingMembers).forEach(tournaments::add);
            return new ResponseEntity<>(tournaments, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/savePastTournaments")
    public String save(@RequestBody PastTournaments tournaments){
        pastTournamentsRepository.save(tournaments);
        return "Saved ";
    }

    @PutMapping(value = "/updatePastTournaments/{id}")
    public String updateTournament(@PathVariable long id, @RequestBody PastTournaments pastTournaments) throws Exception {
        try {
            PastTournaments updatedPastTournaments = pastTournamentsRepository.findById(id).get();
            updatedPastTournaments.setCashPrize(pastTournaments.getCashPrize());
            updatedPastTournaments.setEntryFee(pastTournaments.getEntryFee());
            updatedPastTournaments.setLocation(pastTournaments.getLocation());
            updatedPastTournaments.setFinalStandings(pastTournaments.getFinalStandings());
            updatedPastTournaments.setParticipatingMembers(pastTournaments.getParticipatingMembers());
            updatedPastTournaments.setStartDate(pastTournaments.getStartDate());
            updatedPastTournaments.setEndDate(pastTournaments.getEndDate());

            pastTournamentsRepository.save(updatedPastTournaments);
            return "updated...";
        }
        catch(Exception e){
            throw new Exception("The concept of a controller should be to make life easier...");
        }
    }


    @DeleteMapping(value="/deletePastTournaments/{id}")
    public String deleteTournament(@PathVariable long id){
        PastTournaments deleteT = pastTournamentsRepository.findById(id).get();
        pastTournamentsRepository.delete(deleteT);
        return "Deleted user with the id: "+id;
    }
}
