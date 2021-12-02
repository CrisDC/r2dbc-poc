package com.experiments.r2dbcpoc.university.business;

import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import com.experiments.r2dbcpoc.university.model.repository.Student;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StudentService {

    Mono<StudentReportDTO> findStudentReport(String codAlu);

    Flux<Student> findAll();

    Mono<Boolean> existsById(String codAlu);

    Mono<Student> save(Student student);

    Mono<Student> update(Student student);

    Mono<Void> deleteById(String codAlu);

}
