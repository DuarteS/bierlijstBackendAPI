package com.huizekb.bierlijst.bierlijst.web;


import com.huizekb.bierlijst.bierlijst.domain.Member;
import com.huizekb.bierlijst.bierlijst.exception.DataNotFoundException;
import com.huizekb.bierlijst.bierlijst.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @Value("${accesskey}")
    private String accessKey;


    @Value("${secretkey}")
    private String secretKey;

    @Value("${region}")
    private String region;

    @Value("${endpoint}")
    private String endpoint;

    @GetMapping()
    public List<Member> all() {
        return memberService.getAll();

    }

    @GetMapping(value = "/test")
    public String allq() {
        return accessKey+" "+secretKey+" "+ region+" "+endpoint;

    }

    @PostMapping()
    public Member save(@RequestBody Member member) {
        return memberService.create(member);
    }

    @PutMapping(value = "/{id}")
    public Member update(@PathVariable("id") String id, @RequestBody Member member) {
        return memberService.update(member,id);
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable(value = "id") String id) {
        return memberService.getById(id).orElseThrow(() -> new DataNotFoundException("not found"));
    }
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable(value = "id") String id) {
        memberService.delete(id);
    }

}
