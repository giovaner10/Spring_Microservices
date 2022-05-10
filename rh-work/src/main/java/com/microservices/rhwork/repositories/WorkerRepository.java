package com.microservices.rhwork.repositories;

import com.microservices.rhwork.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
