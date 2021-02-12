package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.entities.Operation;


public interface OperationRepository extends JpaRepository<Operation, Long>{
    Page<Operation> findByCompte_Code(Long code, Pageable pageable);
}
