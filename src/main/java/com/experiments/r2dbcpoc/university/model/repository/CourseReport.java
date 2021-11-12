package com.experiments.r2dbcpoc.university.model.repository;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(value = "course_report")
public class CourseReport {

    @Id
    private String codCur;
    private String codAlu;
    private String nomCur;
    private Integer credito;
    private Integer nota;

}
