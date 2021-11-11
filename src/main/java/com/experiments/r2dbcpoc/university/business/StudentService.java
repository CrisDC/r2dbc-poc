package com.experiments.r2dbcpoc.university.business;

import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import reactor.core.publisher.Mono;

public interface StudentService {

    Mono<StudentReportDTO> findStudentReport(String codAlu);

}
