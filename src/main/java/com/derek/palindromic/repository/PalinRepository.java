package com.derek.palindromic.repository;

import com.derek.palindromic.entity.Palin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PalinRepository extends CrudRepository<Palin, String> {
    public Optional<Palin> findByOrigin(String origin);
    public Palin save(Palin palin);
}
