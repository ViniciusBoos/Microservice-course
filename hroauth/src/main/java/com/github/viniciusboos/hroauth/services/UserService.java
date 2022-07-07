package com.github.viniciusboos.hroauth.services;

import com.github.viniciusboos.hroauth.entities.User;
import com.github.viniciusboos.hroauth.feignclients.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserFeignClient userFeignClient;

    public User findByEmail(String email) {
        User user = userFeignClient.findByEmail(email).getBody();

        if(user == null) {
            System.out.println("Email not found" + email);
            throw new IllegalArgumentException("Email not found");
        }
        System.out.println("Email found" + email);

        return user;
    }
}
