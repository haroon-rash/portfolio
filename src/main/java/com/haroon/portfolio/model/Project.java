package com.haroon.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String tags; // Comma separated tags e.g. "Spring Cloud, DDD"

    private String githubUrl;
    private String liveUrl; // Optional live link
}
