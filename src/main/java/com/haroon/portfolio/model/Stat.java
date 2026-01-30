package com.haroon.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "stats")
public class Stat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String count; // e.g. "5+"
    private String label; // e.g. "Enterprise Projects"
}
