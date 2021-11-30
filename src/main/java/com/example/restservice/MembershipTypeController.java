package com.example.restservice;

import com.example.accessingdatarest.MembershipType;
import com.example.Repositories.MembershipTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MembershipTypeController {

    @Autowired
    private MembershipTypeRepository membership_typeRepository;

    @GetMapping(value="/getMembershipType")
    public Iterable<MembershipType> getMembers(){
        return membership_typeRepository.findAll();
    }

    @PostMapping(value = "/saveMembershipType")
    public String saveMembershipType (@RequestBody MembershipType membershipType){
        membership_typeRepository.save(membershipType);
        return "Saved MembershipType";
    }
    @PutMapping(value="/updateMembershipType/{id}")
    public String updateMembershipType( @PathVariable long id, @RequestBody MembershipType membershipType){
        MembershipType updatedMembershipType = membership_typeRepository.findById(id).get();
        updatedMembershipType.setMembership_type(membershipType.getMembership_type());

        membership_typeRepository.save(updatedMembershipType);
        return "updated membership Type";
    }
    @DeleteMapping(value="/deleteMembershipType/{id}")
    public String deleteTournament(@PathVariable long id){
        MembershipType deleteM = membership_typeRepository.findById(id).get();
        membership_typeRepository.delete(deleteM);
        return "Deleted user with the id: "+id;
    }

}
