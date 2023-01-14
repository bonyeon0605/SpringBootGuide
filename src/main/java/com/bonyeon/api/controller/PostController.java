package com.bonyeon.api.controller;

import com.bonyeon.api.dto.MemberDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, String> postData) {
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(data -> {
            sb.append(data.getKey() + " : " + data.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMember2(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }
}
