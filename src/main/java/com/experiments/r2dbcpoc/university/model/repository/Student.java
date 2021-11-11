package com.experiments.r2dbcpoc.university.model.repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "Alumnos")
public class Student {

    @Id
    private String codAlu;
    private String nomAlu;
    private String apeAlu;

}
