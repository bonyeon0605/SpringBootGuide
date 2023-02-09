package com.bonyeon.jpa.data.dto;

import com.bonyeon.jpa.data.group.ValidationGroup1;
import com.bonyeon.jpa.data.group.ValidationGroup2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValidatedRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    @Pattern(regexp = "(\\d{3})(\\d{3,4})(\\d{4})")
    String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup2.class)
    int age;

    @Size(min = 0, max = 20)
    String description;

    @Positive(groups = ValidationGroup2.class)
    int count;

    @AssertTrue
    boolean booleanCheck;

}
