package com.bonyeon.api.controller;

import com.bonyeon.api.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {

    @PutMapping("/member")
    public String putMember(@RequestBody Map<String, String> putData) {
        StringBuilder sb = new StringBuilder();

        putData.entrySet().forEach(data -> {
            sb.append(data.getKey() + " : " + data.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping("/member1")
    public String putMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

    @PutMapping("/member2")
    public MemberDto putMemberDto2(@RequestBody MemberDto memberDto) {
        return memberDto;
    }

    @PutMapping("member3")
    public ResponseEntity<MemberDto> putMemberDto3(@RequestBody MemberDto memberDto) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(memberDto);
    }
}
