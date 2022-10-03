package com.devsuperior.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hrworker.entities.Worker;

/*
 * Objeto que vai fazer o acesso ao BD
 * Interface que herda de JpaRepository que terão métodos para acesso aos dados
 */
public interface WorkerRepository extends JpaRepository<Worker, Long> {

}
