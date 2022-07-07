package com.github.viniciusboos.hruser.resources;

import com.github.viniciusboos.hruser.entities.User;
import com.github.viniciusboos.hruser.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        Optional<User> possibleWorker = userRepository.findById(id);
        return possibleWorker.map(ResponseEntity::ok).orElse(null);
    }

    @GetMapping(value = "/search")
    public ResponseEntity<User> findByEmail(@RequestParam String email){

        Optional<User> possibleWorker = userRepository.findByEmail(email);
        return possibleWorker.map(ResponseEntity::ok).orElse(null);
    }
}