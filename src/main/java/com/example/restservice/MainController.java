package com.example.restservice;

//import com.example.accessingdatarest.Member;
//import com.example.accessingdatarest.MemberRepository;
import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.Tournaments;
import com.example.accessingdatarest.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private TournamentsRepository tournamentsRepository;

    @GetMapping("/welcome")
    public String getPage() {
        return "Welcome to the CRUD App";
    }

    @GetMapping(value = "/all")
    public Iterable<Tournaments> getMembers(){
        return tournamentsRepository.findAll();
    }

    @GetMapping(value = "/members")
    public ResponseEntity<List<Member>> findByLastName(@RequestParam String lastname){
        try {
            List<Member> member = new ArrayList<Member>();
            tournamentsRepository.findByLastName(lastname).forEach(member::add);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/phone")
    public ResponseEntity<List<Member>> findByPhone(@RequestParam int phone){
        try {
            List<Member> member = new ArrayList<Member>();
            tournamentsRepository.findByPhone(phone).forEach(member::add);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping(value = "/current")
    public ResponseEntity<List<Member>> findByCurrentNumTournaments(@RequestParam int currentNumTournaments){
        try {
            List<Member> member = new ArrayList<Member>();
            tournamentsRepository.findByCurrentNumTournaments(currentNumTournaments).forEach(member::add);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/past")
    public ResponseEntity<List<Member>> findByPastNumTournaments(@RequestParam int pastNumTournaments){
        try {
            List<Member> member = new ArrayList<Member>();
            tournamentsRepository.findByPastNumTournaments(pastNumTournaments).forEach(member::add);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/future")
    public ResponseEntity<List<Member>> findByFutureNumTournaments(@RequestParam int futureNumTournaments){
        try {
            List<Member> member = new ArrayList<Member>();
            tournamentsRepository.findByFutureNumTournaments(futureNumTournaments).forEach(member::add);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/save")
    public String saveMember (@RequestBody Tournaments tournaments){
        tournamentsRepository.save(tournaments);
        return "Saved";
    }

    @PutMapping(value = "update/{id}")
    public String updateMember(@PathVariable long id, @RequestBody Tournaments tournaments){
        Tournaments updatedTournaments = tournamentsRepository.findById(id).get();
        updatedTournaments.setFirstName(tournaments.getFirstName());
        updatedTournaments.setLastName(tournaments.getLastName());
        updatedTournaments.setAddress(tournaments.getAddress());
        updatedTournaments.setEmail(tournaments.getEmail());
        updatedTournaments.setPhone(tournaments.getPhone());
        updatedTournaments.setDurationOfMembership(tournaments.getDurationOfMembership());
        updatedTournaments.setMembershipType(tournaments.getMembershipType());
        updatedTournaments.setCurrentNumTournaments(tournaments.getCurrentNumTournaments());
        updatedTournaments.setFutureNumTournaments(tournaments.getFutureNumTournaments());
        updatedTournaments.setPastNumTournaments(tournaments.getPastNumTournaments());
        updatedTournaments.setEndDate(tournaments.getEndDate());
        updatedTournaments.setStartDate(tournaments.getStartDate());
        updatedTournaments.setCashPrize(tournaments.getCashPrize());
        updatedTournaments.setEntryFee(tournaments.getEntryFee());
        tournamentsRepository.save(updatedTournaments);
        return "updated...";
    }

    @DeleteMapping(value="/delete/{id}")
    public String deleteMember(@PathVariable long id){
        Tournaments deleteMember = tournamentsRepository.findById(id).get();
        tournamentsRepository.delete(deleteMember);
        return "Deleted user with the id: "+id;
    }
}