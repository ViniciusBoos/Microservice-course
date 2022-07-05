package com.github.viniciusboos.hrworkers.resources;

import com.github.viniciusboos.hrworkers.entities.Worker;
import com.github.viniciusboos.hrworkers.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){
        Optional<Worker> possibleWorker = workerRepository.findById(id);
        return possibleWorker.map(ResponseEntity::ok).orElse(null);
    }
}
