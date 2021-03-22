package com.derek.palindromic.repository;

import com.derek.palindromic.entity.Palin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PalinRepository extends CrudRepository<Palin, String> {
    Optional<Palin> findByOrigin(String origin);
    Palin save(Palin palin);
    List<Palin> findAll();
}
