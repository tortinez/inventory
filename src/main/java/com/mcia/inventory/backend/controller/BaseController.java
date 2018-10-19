package com.mcia.inventory.backend.controller;

import com.mcia.inventory.backend.service.BaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RequiredArgsConstructor
@RestController
abstract class BaseController<T, R> {

    private final String path;
    private final BaseService<T, R> service;

    @GetMapping
    Iterable<T> search(@RequestParam(value = "q", defaultValue = "") String query, Pageable pageable) {
        return findBy(query, pageable);
    }

    Iterable<T> findBy(String query, Pageable pageable) {
        log.debug("GET {}", path);
        return service.findAll();
    }

    @GetMapping("/{id}")
    T findById(@PathVariable Long id) {
        log.debug("GET {}/{}", path, id);
        return service.findById(id);
    }

    @PostMapping
    T create(@RequestBody R request) {
        log.debug("POST {} {}", path, request);
        return service.create(request);
    }

    @PutMapping("/{id")
    T update(@PathVariable Long id, @RequestBody R request) {
        log.debug("PUT {}/{} {}", path, id, request);
        return service.update(id, request);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable Long id) {
        log.debug("DELETE {}/{}", path, id);
        service.deleteById(id);
    }


}
