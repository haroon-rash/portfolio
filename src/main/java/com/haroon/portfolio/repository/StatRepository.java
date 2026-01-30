package com.haroon.portfolio.repository;

import com.haroon.portfolio.model.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {
}
