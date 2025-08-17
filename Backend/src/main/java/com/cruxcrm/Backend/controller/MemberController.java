package com.cruxcrm.Backend.controller;

import com.cruxcrm.Backend.DTO.Request.MemberRequestDto;
import com.cruxcrm.Backend.DTO.Response.MemberResponseDto;
import com.cruxcrm.Backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<List<MemberResponseDto>> getMembers() {
        return new ResponseEntity<>(memberService.getMembers(), HttpStatus.OK);
    }

    @PostMapping("/member")
    public ResponseEntity<MemberResponseDto> addMember(@RequestBody MemberRequestDto memberDto) {
        return new ResponseEntity<>(memberService.addMember(memberDto), HttpStatus.OK);
    }
}
