package com.example.restservice;

import com.example.Repositories.MemberRepository;
import com.example.Repositories.MembershipTypeRepository;
import com.example.accessingdatarest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;



@RestController
public class MemberController {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MembershipTypeRepository membershipTypeRepository;


    @GetMapping("/welcome")
    public String getPage() {
        return "Welcome to the CRUD App";
    }




    @GetMapping(value = "/members")
    public ResponseEntity<List<Member>> findByLastName(@RequestParam String lastname){
        try {
            List<Member> member = new ArrayList<Member>();
            memberRepository.findByLastName(lastname).forEach(member::add);
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
            memberRepository.findByPhone(phone).forEach(member::add);
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
            memberRepository.findByCurrentNumTournaments(currentNumTournaments).forEach(member::add);
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
            memberRepository.findByPastNumTournaments(pastNumTournaments).forEach(member::add);
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
            memberRepository.findByFutureNumTournaments(futureNumTournaments).forEach(member::add);
            return new ResponseEntity<>(member, HttpStatus.OK);
        }
        catch(Exception exception){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping(value = "/saveMember")
    public String saveMember (@RequestBody Member member){
        memberRepository.save(member);
        return "Saved Member";
    }

    @PutMapping(value = "/updateMember/{id}")
    public ResponseEntity<Member>updateMember(@PathVariable long id, @RequestBody Member member){
        Member updatedMember = memberRepository.findById(id).get();
        updatedMember.setLastName(member.getLastName());
        updatedMember.setFirstName(member.getFirstName());
        updatedMember.setPhone(member.getPhone());
        updatedMember.setAddress(member.getAddress());
        updatedMember.setEmail(member.getEmail());
        updatedMember.setDurationOfMembership(member.getDurationOfMembership());
        updatedMember.setCurrentNumTournaments(member.getCurrentNumTournamentsList());
        updatedMember.setPastNumTournamentsList(member.getPastNumTournamentsList());
        updatedMember.setFutureNumTournamentsList(member.getFutureNumTournamentsList());
        updatedMember.setStartOfMembership(member.getStartOfMembership());
        updatedMember.setMembershipType(member.getMembershipType());

        return new ResponseEntity<>(memberRepository.save(updatedMember), HttpStatus.OK);
    }

    @DeleteMapping(value="/deleteMember/{id}")
    public String deleteTournament(@PathVariable long id){
        Member deleteM = memberRepository.findById(id).get();
        memberRepository.delete(deleteM);
        return "Deleted user with the id: "+id;
    }


}