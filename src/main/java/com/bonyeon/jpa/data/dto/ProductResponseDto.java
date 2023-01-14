package com.bonyeon.jpa.data.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponseDto {

    private Long number;
    private String name;
    private int price;
    private int stock;
}
