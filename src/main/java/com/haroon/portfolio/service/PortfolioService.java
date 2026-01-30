package com.haroon.portfolio.service;

import com.haroon.portfolio.model.*;
import com.haroon.portfolio.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    @Autowired
    private HeroSectionRepository heroRepository;
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private StatRepository statRepository;
    @Autowired
    private ContactInfoRepository contactInfoRepository;

    public HeroSection getHeroSection() {
        return heroRepository.findAll().stream().findFirst().orElse(new HeroSection());
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    public List<Stat> getAllStats() {
        return statRepository.findAll();
    }

    public ContactInfo getContactInfo() {
        return contactInfoRepository.findAll().stream().findFirst().orElse(new ContactInfo());
    }

    // Save methods for Admin
    public void saveHeroSection(HeroSection heroSection) {
        heroRepository.save(heroSection);
    }

    public void saveProject(Project project) {
        projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project getProjectById(Long id) {
        return projectRepository.findById(id).orElse(null);
    }

    public void saveSkill(Skill skill) {
        skillRepository.save(skill);
    }

    public void deleteSkill(Long id) {
        skillRepository.deleteById(id);
    }

    public Skill getSkillById(Long id) {
        return skillRepository.findById(id).orElse(null);
    }

    public void saveStat(Stat stat) {
        statRepository.save(stat);
    }

    public void deleteStat(Long id) {
        statRepository.deleteById(id);
    }

    public Stat getStatById(Long id) {
        return statRepository.findById(id).orElse(null);
    }

    public void saveContactInfo(ContactInfo contactInfo) {
        contactInfoRepository.save(contactInfo);
    }
}
