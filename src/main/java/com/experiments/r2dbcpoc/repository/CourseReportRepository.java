package com.experiments.r2dbcpoc.repository;

import com.experiments.r2dbcpoc.university.model.repository.CourseReport;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface CourseReportRepository extends ReactiveSortingRepository<CourseReport, String> {

        Flux<CourseReport> findCourseReportByCodAlu(String codAlu);

}
