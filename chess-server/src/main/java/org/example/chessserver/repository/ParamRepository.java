package org.example.chessserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ParamRepository extends JpaRepository<Param, Integer> {
    Optional<Param> findByKey(String key);
}
