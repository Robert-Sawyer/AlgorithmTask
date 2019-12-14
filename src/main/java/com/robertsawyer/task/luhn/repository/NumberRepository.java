package com.robertsawyer.task.luhn.repository;

import com.robertsawyer.task.luhn.entity.Number;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepository extends JpaRepository<Number, Long> {


}
