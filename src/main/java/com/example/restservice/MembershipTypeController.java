package com.example.restservice;

import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.MembershipType;
import com.example.Repositories.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MembershipTypeController {

    @Autowired
    private MembershipTypeRepository membershipTypeRepository;

    @GetMapping(value="/getMembershipType")
    public Iterable<MembershipType> getMembers(){
        return membershipTypeRepository.findAll();
    }

    @PostMapping(value = "/saveMembershipType")
    public String saveMembershipType (@RequestBody MembershipType membershipType){
        membershipTypeRepository.save(membershipType);
        return "Saved MembershipType";
    }
    @PutMapping(value="/updateMembershipType/{id}")
    public String updateMembershipType(@PathVariable long id, @RequestBody MembershipType membershipType){
        MembershipType updatedMembershipType = membershipTypeRepository.findById(id).get();
        updatedMembershipType.setMembershipType(membershipType.getMembershipType());

        membershipTypeRepository.save(updatedMembershipType);
        return "updated membership Type";
    }
    @DeleteMapping(value="/deleteMembershipType/{id}")
    public String deleteTournament(@PathVariable long id){
        MembershipType deleteM = membershipTypeRepository.findById(id).get();
        membershipTypeRepository.delete(deleteM);
        return "Deleted user with the id: "+id;
    }

}
