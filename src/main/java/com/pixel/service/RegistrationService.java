package com.pixel.service;

import java.util.Objects;

import com.pixel.entity.Student;
import com.pixel.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Transactional
@AllArgsConstructor
public class RegistrationService {

    @Autowired
    private StudentRepository studentRepository;
    public Flux<Student> getAll() {
        return studentRepository.findAll().switchIfEmpty(Flux.empty());
    }
    public Mono<Student> getById(final String id) {
        return studentRepository.findById(id);
    }
    public Mono update(final String id, final Student student) {
        return studentRepository.save(student);
    }
    public Mono save(final Student student) {
        return studentRepository.save(student);
    }

    public Mono delete(final String id) {
        final Mono<Student> dbStudent = getById(id);
        if (Objects.isNull(dbStudent)) {
            return Mono.empty();
        }
        return getById(id).switchIfEmpty(Mono.empty()).filter(Objects::nonNull).flatMap(studentToBeDeleted -> studentRepository
                .delete(studentToBeDeleted).then(Mono.just(studentToBeDeleted)));
    }
}
