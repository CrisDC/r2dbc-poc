package com.experiments.r2dbcpoc.web;

import com.experiments.r2dbcpoc.university.business.CourseService;
import com.experiments.r2dbcpoc.university.model.repository.Course;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public Flux<Course> findAllCourses() {
        return this.courseService.findAll();
    }

    @PostMapping
    public Mono<Course> saveCourse(@RequestBody Course course) {
        return this.courseService.save(course);
    }

    @PutMapping
    public Mono<Course> updateCourse(@RequestBody Course course) {
        return this.courseService.update(course);
    }

    @DeleteMapping
    public Mono<Void> deleteCourse(@RequestParam String codCur) {
        return this.courseService.deleteById(codCur);
    }

}
