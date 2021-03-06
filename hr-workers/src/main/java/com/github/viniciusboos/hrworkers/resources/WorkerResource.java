package com.github.viniciusboos.hrworkers.resources;

import com.github.viniciusboos.hrworkers.entities.Worker;
import com.github.viniciusboos.hrworkers.repository.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/workers")
public class WorkerResource {

    private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

    @Value("${test.config}")
    private String testConfig;

    @Autowired
    private Environment environment;

    @Autowired
    private WorkerRepository workerRepository;

    @GetMapping("/configs")
    public ResponseEntity<List<Worker>> findConfigs(){
        logger.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll(){
        return ResponseEntity.ok(workerRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id){

        logger.info("PORT = " + environment.getProperty("local.server.port"));

        Optional<Worker> possibleWorker = workerRepository.findById(id);
        return possibleWorker.map(ResponseEntity::ok).orElse(null);
    }
}
