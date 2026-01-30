package com.haroon.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category; // e.g. "Languages", "Frameworks"

    @Column(length = 1000)
    private String items; // e.g. "Java, SQL, C/C++"
}
