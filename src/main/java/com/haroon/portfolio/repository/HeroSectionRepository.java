package com.haroon.portfolio.repository;

import com.haroon.portfolio.model.HeroSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeroSectionRepository extends JpaRepository<HeroSection, Long> {
}
