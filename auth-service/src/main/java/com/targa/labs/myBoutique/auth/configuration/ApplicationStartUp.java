package com.targa.labs.myBoutique.auth.configuration;

import com.targa.labs.myBoutique.auth.domain.User;
import com.targa.labs.myBoutique.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

@Component
public class ApplicationStartUp {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StartupProperties startupProperties;

    @Bean
    public CommandLineRunner loadData(){
        return (args) -> {
            List<User> users = userRepository.findAll();

            User admin = new User("Admin01"
                    ,"Admin01@gmail.com"
                    ,BCrypt.hashpw("123Admin",BCrypt.gensalt())
                    ,'Y'
                    ,0
                    ,Arrays.asList("ADMIN"));


            if (ObjectUtils.isEmpty(users)){
                this.userRepository.save(admin);
            }
        };
    }

}
