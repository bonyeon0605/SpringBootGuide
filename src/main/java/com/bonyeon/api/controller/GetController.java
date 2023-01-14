package com.bonyeon.api.controller;

import com.bonyeon.api.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger log = LoggerFactory.getLogger(GetController.class);

    @GetMapping("/hello")
    public String getHello() {
        log.info("getHello 메서드를 호출되었습니다.");
        return "Hello World";
    }

    @GetMapping("/name")
    public String getName() {
        return "Bonyeon.";
    }

    // {variable} 과 파라미터의 변수명이 일치해야 한다.
    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    @ApiOperation(value = "GET 메서드 예제", notes = "@RequestParam을 활용한 GET Method")
    @GetMapping("/request1")
    public String getRequestParam1(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email,
            @ApiParam(value = "연락처", required = true) @RequestParam String phone
    ) {
        return name + " " + email + " " + phone;
    }

    @GetMapping("request2")
    public String getRequestParam2(
            @RequestParam Map<String, String> params
    ) {
        StringBuilder sb = new StringBuilder();
        params.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
            System.out.println(map.getKey() + " : " + map.getValue());
        });

        return sb.toString();
    }

    @GetMapping("/request3")
    public String getRequestParam3(MemberDto memberDto) {

        return memberDto.toString();
    }
}
