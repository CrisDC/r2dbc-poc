package com.experiments.r2dbcpoc.university.business.impl;

import com.experiments.r2dbcpoc.repository.CourseReportRepository;
import com.experiments.r2dbcpoc.repository.StudentRepository;
import com.experiments.r2dbcpoc.university.business.StudentService;
import com.experiments.r2dbcpoc.university.model.dto.CourseReportDTO;
import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import com.experiments.r2dbcpoc.university.model.mapper.StudentReportMapper;
import com.experiments.r2dbcpoc.university.model.repository.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final CourseReportRepository courseReportRepository;
    private final R2dbcEntityTemplate template;

    @Override
    public Mono<StudentReportDTO> findStudentReport(String codAlu) {
        return courseReportRepository.findCourseReportByCodAlu(codAlu)
                .collectList()
                .zipWith(studentRepository.findStudentByCodAlu(codAlu),
                        (courseReports ,student) -> StudentReportMapper.repoToDTO(student, courseReports))
                .map(this::calculateProm);
    }

    @Override
    public Flux<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public Mono<Boolean> existsById(String codAlu) {
        return this.studentRepository.existsById(codAlu);
    }

    @Override
    public Mono<Student> save(Student student) {
        return template.insert(Student.class)
                    .using(student);
    }

    @Override
    public Mono<Student> update(Student student) {
        return this.studentRepository.existsById(student.getCodAlu())
                .map(exists -> {
                    if(Boolean.TRUE.equals(exists))
                        return this.studentRepository.save(student);
                    throw new RuntimeException("El alumno ingresado no está registrado");
                })
                .onErrorMap(error -> error)
                .flatMap(s -> s);
    }

    @Override
    public Mono<Void> deleteById(String codAlu) {
        return this.studentRepository.deleteById(codAlu);
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
