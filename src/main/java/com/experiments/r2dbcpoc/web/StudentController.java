package com.experiments.r2dbcpoc.web;

import com.experiments.r2dbcpoc.university.business.StudentService;
import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/report")
    public Mono<StudentReportDTO> findStudentReport(@RequestParam String codAlu) {
        return studentService.findStudentReport(codAlu);
    }

}
