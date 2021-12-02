package com.experiments.r2dbcpoc.university.business.impl;

import com.experiments.r2dbcpoc.repository.CourseRepository;
import com.experiments.r2dbcpoc.university.business.CourseService;
import com.experiments.r2dbcpoc.university.model.repository.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final R2dbcEntityTemplate template;


    @Override
    public Flux<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public Mono<Boolean> existsById(String codCur) {
        return this.courseRepository.existsById(codCur);
    }

    @Override
    public Mono<Course> save(Course course) {
        return this.template.insert(Course.class)
                .using(course);
    }

    @Override
    public Mono<Course> update(Course course) {
        return this.existsById(course.getCodCur())
                .map(exists -> {
                    if(Boolean.TRUE.equals(exists))
                        return this.courseRepository.save(course);
                    throw new RuntimeException("El curso ingresado no está registrado");
                })
                .onErrorMap(error -> error)
                .flatMap(c -> c);
    }

    @Override
    public Mono<Void> deleteById(String codCur) {
        return this.courseRepository.deleteById(codCur);
    }
}
