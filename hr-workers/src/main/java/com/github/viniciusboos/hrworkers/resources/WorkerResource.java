package com.github.viniciusboos.hrworkers.resources;

import com.github.viniciusboos.hrworkers.entities.Worker;
import com.github.viniciusboos.hrworkers.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerResource {

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(workerRepository.findAll());
    }
}
