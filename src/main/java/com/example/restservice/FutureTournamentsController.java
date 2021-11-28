package com.example.restservice;

import com.example.Repositories.FutureTournamentsRepository;
import com.example.accessingdatarest.FutureTournaments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class FutureTournamentsController {
    @Autowired
    private FutureTournamentsRepository FutureTournamentsRepository;

    @GetMapping(value = "/allFutureTournaments")
    public Iterable<FutureTournaments> getMembers(){
        return FutureTournamentsRepository.findAll();
    }
//    @GetMapping(value="/getFutureTour")
//    public ResponseEntity<List<FutureTournaments>> findByParticipationMembers(@RequestParam String participatingMembers){
//        try {
//            List<FutureTournaments> tournaments = new ArrayList<FutureTournaments>();
//            FutureTournamentsRepository.findByParticipatingMembers(participatingMembers).forEach(tournaments::add);
//            return new ResponseEntity<>(tournaments, HttpStatus.OK);
//        }
//        catch(Exception exception){
//            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @PostMapping(value = "/saveFutureTournaments")
    public String save(@RequestBody FutureTournaments tournaments){
        FutureTournamentsRepository.save(tournaments);
        return "Saved ";
    }

    @PutMapping(value = "/updateFutureTournaments/{id}")
    public String updateTournament(@PathVariable long id, @RequestBody FutureTournaments FutureTournaments) throws Exception {
        try {
            FutureTournaments updatedFutureTournaments = FutureTournamentsRepository.findById(id).get();
            updatedFutureTournaments.setCashPrize(FutureTournaments.getCashPrize());
            updatedFutureTournaments.setEntryFee(FutureTournaments.getEntryFee());
            updatedFutureTournaments.setLocation(FutureTournaments.getLocation());
            updatedFutureTournaments.setFinalStandings(FutureTournaments.getFinalStandings());
            updatedFutureTournaments.setParticipatingMembers(FutureTournaments.getParticipatingMembers());
            updatedFutureTournaments.setStartDate(FutureTournaments.getStartDate());
            updatedFutureTournaments.setEndDate(FutureTournaments.getEndDate());

            FutureTournamentsRepository.save(updatedFutureTournaments);
            return "updated...";
        }
        catch(Exception e){
            throw new Exception("The concept of a controller should be to make life easier...");
        }
    }


    @DeleteMapping(value="/deleteFutureTournaments/{id}")
    public String deleteTournament(@PathVariable long id){
        FutureTournaments deleteFutureTournaments = FutureTournamentsRepository.findById(id).get();
        FutureTournamentsRepository.delete(deleteFutureTournaments);
        return "Deleted user with the id: "+id;
    }
}
