package com.experiments.r2dbcpoc.university.model.mapper;

import com.experiments.r2dbcpoc.university.model.dto.CourseReportDTO;
import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import com.experiments.r2dbcpoc.university.model.repository.CourseReport;
import com.experiments.r2dbcpoc.university.model.repository.Student;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class StudentReportMapper {

    public static StudentReportDTO repoToDTO(Student student, List<CourseReport> courseReports) {
        StudentReportDTO dto = new StudentReportDTO();
        dto.setCodAlu(student.getCodAlu());
        dto.setNomAlu(student.getNomAlu());
        dto.setApeAlu(student.getApeAlu());
        dto.setCourseReports(getCourseReports(courseReports));

        return dto;
    }

    private static List<CourseReportDTO> getCourseReports(List<CourseReport> courseReports) {
        return courseReports.stream().map(CourseReportMapper::repoToDto).collect(Collectors.toList());
    }

}
