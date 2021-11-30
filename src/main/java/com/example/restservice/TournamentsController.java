package com.example.restservice;

import com.example.accessingdatarest.Tournaments;
import com.example.Repositories.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TournamentsController {

    @Autowired
    private TournamentsRepository tournamentsRepository;

    @GetMapping(value = "/allT")
    public Iterable<Tournaments> getMembers(){
        return tournamentsRepository.findAll();
    }
//    @GetMapping(value="/getTour")
//    public ResponseEntity<List<Tournaments>> findByParticipationMembers(@RequestParam String participatingMembers){
//        try {
//            List<Tournaments> tournaments = new ArrayList<Tournaments>();
//            tournamentsRepository.findByParticipatingMembers(participatingMembers).forEach(tournaments::add);
//            return new ResponseEntity<>(tournaments, HttpStatus.OK);
//        }
//        catch(Exception exception){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping(value = "/saveTournaments")
    public String save(@RequestBody Tournaments tournaments){
        tournamentsRepository.save(tournaments);
        return "Saved ";
    }

    @PutMapping(value = "/updateTournaments/{id}")
    public String updateCurrentTournament(@PathVariable long id, @RequestBody Tournaments tournaments) throws Exception {
        try {
            Tournaments updatedTournaments = tournamentsRepository.findById(id).get();
            updatedTournaments.setCashPrize(tournaments.getCashPrize());
            updatedTournaments.setEntryFee(tournaments.getEntryFee());
            updatedTournaments.setLocation(tournaments.getLocation());
            updatedTournaments.setFinalStandings(tournaments.getFinalStandings());

            updatedTournaments.setStartDate(tournaments.getStartDate());
            updatedTournaments.setEndDate(tournaments.getEndDate());

            tournamentsRepository.save(updatedTournaments);
            return "updated...";
        }
        catch(Exception e){
            throw new Exception("The concept of a controller should be to make life easier...");
        }
    }


    @DeleteMapping(value="/deleteTournaments/{id}")
    public String deleteTournament(@PathVariable long id){
        Tournaments deleteT = tournamentsRepository.findById(id).get();
        tournamentsRepository.delete(deleteT);
        return "Deleted user with the id: "+id;
    }
}
