package com.example.restservice;

//import com.example.accessingdatarest.Member;
//import com.example.accessingdatarest.MemberRepository;
import com.example.accessingdatarest.Tournaments;
import com.example.accessingdatarest.TournamentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

    @Autowired
    private TournamentsRepository tournamentsRepository;

    @GetMapping("/welcome")
    public String getPage() {
        return "Welcome to the CRUD App";
    }

    @GetMapping(value = "/members")
    public Iterable<Tournaments> getMembers(){
        return tournamentsRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveMember (@RequestBody Tournaments tournaments){
        tournamentsRepository.save(tournaments);
        return "Saved";
    }

    @PutMapping(value = "update/{id}")
    public String updateMember(@PathVariable long id, @RequestBody Tournaments tournaments){
        Tournaments updatedTournaments = tournamentsRepository.findById(id).get();
        updatedTournaments.setLastName(tournaments.getLastName());
        updatedTournaments.setPhone(tournaments.getPhone());
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