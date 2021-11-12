package com.experiments.r2dbcpoc.university.model.mapper;

import com.experiments.r2dbcpoc.university.model.dto.CourseReportDTO;
import com.experiments.r2dbcpoc.university.model.repository.CourseReport;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CourseReportMapper {

    public static CourseReportDTO repoToDto(CourseReport courseReport) {
        CourseReportDTO dto = new CourseReportDTO();
        dto.setCodCur(courseReport.getCodCur().trim());
        dto.setNomCur(courseReport.getNomCur());
        dto.setCredito(courseReport.getCredito());
        dto.setNota(courseReport.getNota());

        return dto;
    }

}
