package com.bonyeon.jpa.data.controller;

import com.bonyeon.jpa.data.dto.ValidRequestDto;
import com.bonyeon.jpa.data.dto.ValidatedRequestDto;
import com.bonyeon.jpa.data.group.ValidationGroup1;
import com.bonyeon.jpa.data.group.ValidationGroup2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/validation")
public class ValidationController {

    private final Logger LOGGER = LoggerFactory.getLogger(ValidationController.class);

    @PostMapping("/validated")
    public ResponseEntity<String> checkValidationByValid(
            @Validated @RequestBody ValidRequestDto validRequestDto) {

        LOGGER.info(validRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validRequestDto.toString());
    }

    @PostMapping("/validated/group1")
    public ResponseEntity<String> checkValidation1(
            @Validated(ValidationGroup1.class) @RequestBody ValidatedRequestDto validatedRequestDto
            ) {

        LOGGER.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/group2")
    public ResponseEntity<String> checkValidation2(
            @Validated(ValidationGroup2.class) @RequestBody ValidatedRequestDto validatedRequestDto
    ) {

        LOGGER.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/validated/all-group")
    public ResponseEntity<String> checkValidation3(
            @Validated({ValidationGroup1.class, ValidationGroup2.class}) @RequestBody ValidatedRequestDto validatedRequestDto
    ) {

        LOGGER.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }

    @PostMapping("/valid")
    public ResponseEntity<String> checkValidation(
            @Valid @RequestBody ValidatedRequestDto validatedRequestDto
    ) {

        LOGGER.info(validatedRequestDto.toString());

        return ResponseEntity.status(HttpStatus.OK).body(validatedRequestDto.toString());
    }
}
