package com.experiments.r2dbcpoc.repository;

import com.experiments.r2dbcpoc.university.model.repository.Course;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseRepository extends ReactiveSortingRepository<Course, String> {

    Flux<Course> findAll();

    Mono<Boolean> existsById(String codCur);

    Mono<Course> save(Course course);

    Mono<Void> deleteById(String codCur);

}
