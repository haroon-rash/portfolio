package com.haroon.portfolio.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "contact_info")
public class ContactInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;
    private String phone;
    private String githubUrl;
    private String linkedinUrl;
}
