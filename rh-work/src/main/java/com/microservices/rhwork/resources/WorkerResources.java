package com.microservices.rhwork.resources;

import com.microservices.rhwork.entities.Worker;
import com.microservices.rhwork.repositories.WorkerRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
public class WorkerResources {

    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        //return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        List<Worker> all = repository.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        //return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
        Worker byId = repository.findById(id).get();
        return ResponseEntity.ok(byId);
    }
}
