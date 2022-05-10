package com.microservices.rhwork.resources;

import com.microservices.rhwork.entities.Worker;
import com.microservices.rhwork.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/workers")
@AllArgsConstructor
@Log4j2
public class WorkerResources {

    private Environment env;
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        //return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        List<Worker> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        log.info("PORT:" + env.getProperty("local.server.port"));
        //return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        Worker byId = repository.findById(id).get();
        return ResponseEntity.ok(byId);
    }
}
