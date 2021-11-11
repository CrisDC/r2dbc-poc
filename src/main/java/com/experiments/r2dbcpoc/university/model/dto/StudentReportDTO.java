package com.experiments.r2dbcpoc.university.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentReportDTO {

    private String codAlu;
    private String nomAlu;
    private String apeAlu;
    private List<CourseReportDTO> courseReports;

}
