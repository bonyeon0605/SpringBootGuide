package com.bonyeon.jpa.data.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "provider")
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Provider extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
