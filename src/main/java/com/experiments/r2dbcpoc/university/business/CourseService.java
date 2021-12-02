package com.experiments.r2dbcpoc.university.business;

import com.experiments.r2dbcpoc.university.model.repository.Course;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CourseService {

    Flux<Course> findAll();

    Mono<Boolean> existsById(String codCur);

    Mono<Course> save(Course course);

    Mono<Course> update(Course course);

    Mono<Void> deleteById(String codCur);

}
