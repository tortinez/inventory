package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
abstract class BaseController<T> {

    private final BaseRepository<T> repository;

    @GetMapping
    Iterable<T> all() {
        log.debug("GET");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    Optional<T> findById(@PathVariable Long id){
        log.debug("GET {}", id);
        return repository.findById(id);
    }

//    @PostMapping

//    @PutMapping("/{id")

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id){
        log.debug("DELETE {}",id);
        repository.deleteById(id);
    }


}
