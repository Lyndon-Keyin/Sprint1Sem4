package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import com.example.accessingdatarest.Member;
import com.example.accessingdatarest.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {

//    private static final String template = "Hello, %s!";
//    private final AtomicLong counter = new AtomicLong();

//    @GetMapping("/greeting")
//    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return new Greeting(counter.incrementAndGet(), String.format(template, name));
//    }

    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/welcome")
    public String getPage() {
        return "Welcome to the CRUD App";
    }

    @GetMapping(value = "/members")
    public Iterable<Member> getMembers(){
        return memberRepository.findAll();
    }

    @PostMapping(value = "/save")
    public String saveMember (@RequestBody Member member){
        memberRepository.save(member);
        return "Saved";
    }

    @PutMapping(value = "update/{id}")
    public String updateMember(@PathVariable long id, @RequestBody Member member){
        Member updatedMember = MemberRepository.findById(id).get();
        return null;
    }
}