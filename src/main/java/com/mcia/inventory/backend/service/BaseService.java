package com.mcia.inventory.backend.service;

import com.mcia.inventory.backend.repository.BaseRepository;
import com.mcia.inventory.backend.service.converter.RequestConverter;
import com.mcia.inventory.backend.service.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public abstract class BaseService<T, R> {

    private final String resource;
    private final BaseRepository<T> repository;
    private final RequestConverter<T, R> converter;

    @Transactional(readOnly = true)
    public Iterable<T> findAll() {
        return repository.findAll();
    }

//    @Transactional(readOnly = true)
//    public Iterable<T> findAll(Sort sort) {
//        return repository.findAll(sort);
//    }

    @Transactional(readOnly = true)
    public Page<T> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

//    @Transactional(readOnly = true)
//    public List<T> search(Specification<T> specification) {
//        return repository.findAll(specification);
//    }
//
//    @Transactional(readOnly = true)
//    public Page<T> search(Specification<T> specification, Pageable pageable) {
//        return repository.findAll(specification, pageable);
//    }

    @Transactional(readOnly = true)
    public T findById(Long id) {
        return repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(String.format("%s id not found.", resource)));
    }

    @Transactional
    public T create(R request) {
        T entity = repository.save(converter.toEntity(request));
        log.info("Created {}", entity);
        return entity;
    }

    @Transactional
    public T update(Long id, R request) {
        if (repository.existsById(id)) {
            T entity = repository.save(converter.toEntity(request, id));
            log.info("Updated {}", entity);
            return entity;
        } else {
            throw new ResourceNotFoundException(String.format("%s id not found.", resource));
        }
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
        log.info("Deleted {} with id={}", resource, id);
    }


}
