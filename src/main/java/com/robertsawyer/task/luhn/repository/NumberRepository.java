package com.robertsawyer.task.luhn.repository;

import com.robertsawyer.task.luhn.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NumberRepository extends JpaRepository<Number, Long> {


    @Query(value = "SELECT * FROM numbers ORDER BY ID DESC LIMIT 1",
    nativeQuery = true)
    Number findLast();
}
