package com.experiments.r2dbcpoc.university.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseReportDTO {

    private String codCur;
    private String nomCur;
    private Integer credito;
    private Integer nota;

}
