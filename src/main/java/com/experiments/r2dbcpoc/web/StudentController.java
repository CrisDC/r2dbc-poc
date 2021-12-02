package com.experiments.r2dbcpoc.web;

import com.experiments.r2dbcpoc.university.business.StudentService;
import com.experiments.r2dbcpoc.university.model.dto.StudentReportDTO;
import com.experiments.r2dbcpoc.university.model.repository.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
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

    @GetMapping
    public Flux<Student> findAllStudents() {
        return this.studentService.findAll();
    }

    @PostMapping
    public Mono<Student> saveStudent(@RequestBody Student student) {
        return this.studentService.save(student);
    }

    @PutMapping
    public Mono<Student> updateStudent(@RequestBody Student student) {
        return this.studentService.update(student);
    }

    @DeleteMapping
    public Mono<Void> deleteStudent(@RequestParam String codAlu) {
        return this.studentService.deleteById(codAlu);
    }

}
