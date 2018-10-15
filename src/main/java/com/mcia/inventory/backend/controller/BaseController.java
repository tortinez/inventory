package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.repository.BaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
abstract class BaseController<T> {

    private final BaseRepository<T> repository;

    @GetMapping
    List<T> all() {
        log.debug("GET");
        return repository.findAll();
    }


//    @GetMapping("/{id}")
//
//    @PostMapping
//
//    @PutMapping("/{id")
//
//    @DeleteMapping("/{id}")

}
