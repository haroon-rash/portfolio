package com.haroon.portfolio.config;

import com.haroon.portfolio.model.Account;
import com.haroon.portfolio.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @org.springframework.beans.factory.annotation.Value("${app.admin.username}")
    private String adminUsername;

    @org.springframework.beans.factory.annotation.Value("${app.admin.password}")
    private String adminPassword;
@Bean
public CommandLineRunner initData() {
    return args -> {
        System.out.println("Admin username: " + adminUsername); // <-- ADD THIS
        if (accountRepository.findByUsername(adminUsername).isEmpty()) {
            Account admin = new Account();
            admin.setUsername(adminUsername);
            admin.setPassword(passwordEncoder.encode(adminPassword));
            accountRepository.save(admin);
            System.out.println("Admin account created successfully.");
        } else {
            System.out.println("Admin account already exists.");
        }
    };
}

    @Bean
    public CommandLineRunner initData() {
        return args -> {
            if (accountRepository.findByUsername(adminUsername).isEmpty()) {
                Account admin = new Account();
                admin.setUsername(adminUsername);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                accountRepository.save(admin);
                System.out.println("Admin account created successfully.");
            }
        };
    }
}
