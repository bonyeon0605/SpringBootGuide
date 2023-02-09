package com.bonyeon.jpa.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    @Pattern(regexp = "(\\d{3})(\\d{3,4})(\\d{4})")
    String phoneNumber;

    @Min(value = 20) @Max(value = 40)
    int age;

    @Size(min = 0, max = 20)
    String description;

    @Positive
    int count;

    @AssertTrue
    boolean booleanCheck;

}
