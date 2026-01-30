package com.haroon.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "hero_section")
public class HeroSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String title; // "Software Engineer..."

    @Column(length = 1000)
    private String description;

    private String githubUrl;
    private String linkedinUrl;
    private String leetcodeUrl;
    private String email;
}
