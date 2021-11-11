package com.experiments.r2dbcpoc.repository;

import com.experiments.r2dbcpoc.university.model.repository.Student;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveSortingRepository<Student, String> {

    Mono<Student> findStudentByCodAlu(String codAlu);

}
