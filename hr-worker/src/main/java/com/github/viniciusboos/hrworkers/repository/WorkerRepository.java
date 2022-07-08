package com.github.viniciusboos.hrworkers.repository;

import com.github.viniciusboos.hrworkers.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
