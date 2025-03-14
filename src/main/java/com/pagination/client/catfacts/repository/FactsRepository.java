package com.pagination.client.catfacts.repository;

import com.pagination.client.catfacts.entity.Facts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactsRepository extends JpaRepository<Facts, Long> {

    @Query(value = "SELECT id,fact,length_value FROM FACTS WHERE fact = ?1", nativeQuery = true)
    Optional<?> factExistsInDatabase(String fact);


}
