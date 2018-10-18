package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.repository.BaseRepository;
import com.mcia.inventory.backend.service.converter.RequestConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
abstract class BaseService<T, R> {

    protected String resource;
    protected BaseRepository<T> repository;
    protected RequestConverter<T, R> converter;

    @Transactional(readOnly = true)
    Iterable<T> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    Iterable<T> findAll(Sort sort) {
        return repository.findAll(sort);
    }

    @Transactional(readOnly = true)
    Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Transactional(readOnly = true)
    List<T> search(Specification<T> specification) {
        return repository.findAll(specification);
    }

    @Transactional(readOnly = true)
    Page<T> search(Specification<T> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }

    @Transactional(readOnly = true)
    T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    T create(R request) {
        T entity = repository.save(converter.toEntity(request));
        log.info("Created {}", entity);
        return entity;
    }

    @Transactional
    T update(Long id, R request) {
        if (repository.existsById(id)) {
            T entity = repository.save(converter.toEntity(request));
            log.info("Updated {}", entity);
            return entity;
        } else {
            log.info("$resource id not found");
            return null;
        }
    }

    @Transactional
    void deleteById(Long id) {
        repository.deleteById(id);
        log.info("Deleted $resource with id={}",id);
    }


}
