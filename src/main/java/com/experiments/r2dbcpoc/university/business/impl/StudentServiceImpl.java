package com.experiments.r2dbcpoc.university.business.impl;

import com.experiments.r2dbcpoc.repository.CourseReportRepository;
import com.experiments.r2dbcpoc.repository.StudentRepository;
import com.experiments.r2dbcpoc.university.business.StudentService;
import com.experiments.r2dbcpoc.university.model.dto.CourseReportDTO;
import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import com.experiments.r2dbcpoc.university.model.mapper.StudentReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseReportRepository courseReportRepository;

    @Override
    public Mono<StudentReportDTO> findStudentReport(String codAlu) {
        return courseReportRepository.findCourseReportByCodAlu(codAlu)
                .collectList()
                .zipWith(studentRepository.findStudentByCodAlu(codAlu),
                        (courseReports ,student) -> StudentReportMapper.repoToDTO(student, courseReports))
                .map(this::calculateProm);
    }

    private StudentReportDTO calculateProm(StudentReportDTO studentReportDTO) {
        BigDecimal subTotal = BigDecimal.valueOf(
                studentReportDTO.getCourseReports().stream().mapToDouble(report -> report.getNota() * report.getCredito()).sum());
        BigDecimal totalCredits = BigDecimal.valueOf(
                studentReportDTO.getCourseReports().stream().mapToDouble(CourseReportDTO::getCredito).sum());

        studentReportDTO.setProm(subTotal.divide(totalCredits, RoundingMode.UNNECESSARY));

        return studentReportDTO;
    }

}
