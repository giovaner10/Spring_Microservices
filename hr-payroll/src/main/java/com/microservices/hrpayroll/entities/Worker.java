package com.microservices.hrpayroll.entities;

import lombok.*;

import java.io.Serializable;

@Builder

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Worker implements Serializable {

    private static final long serialVersionUID = 1L;


    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private Double dailyIncome;
}
