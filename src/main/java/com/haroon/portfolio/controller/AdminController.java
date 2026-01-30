package com.haroon.portfolio.controller;

import com.haroon.portfolio.model.*;
import com.haroon.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public String dashboard(Model model) {
        model.addAttribute("hero", portfolioService.getHeroSection());
        model.addAttribute("projects", portfolioService.getAllProjects());
        model.addAttribute("skills", portfolioService.getAllSkills());
        model.addAttribute("stats", portfolioService.getAllStats());
        model.addAttribute("contact", portfolioService.getContactInfo());
        return "admin/dashboard";
    }

    // Hero Section
    @PostMapping("/hero/update")
    public String updateHero(@ModelAttribute HeroSection heroSection, RedirectAttributes redirectAttributes) {
        portfolioService.saveHeroSection(heroSection);
        redirectAttributes.addFlashAttribute("success", "Hero section updated successfully!");
        return "redirect:/admin";
    }

    // Contact Info
    @PostMapping("/contact/update")
    public String updateContact(@ModelAttribute ContactInfo contactInfo, RedirectAttributes redirectAttributes) {
        portfolioService.saveContactInfo(contactInfo);
        redirectAttributes.addFlashAttribute("success", "Contact info updated successfully!");
        return "redirect:/admin";
    }

    // Projects
    @GetMapping("/projects/new")
    public String newProject(Model model) {
        model.addAttribute("project", new Project());
        return "admin/project-form";
    }

    @GetMapping("/projects/edit/{id}")
    public String editProject(@PathVariable Long id, Model model) {
        model.addAttribute("project", portfolioService.getProjectById(id));
        return "admin/project-form";
    }

    @PostMapping("/projects/save")
    public String saveProject(@ModelAttribute Project project, RedirectAttributes redirectAttributes) {
        portfolioService.saveProject(project);
        redirectAttributes.addFlashAttribute("success", "Project saved successfully!");
        return "redirect:/admin";
    }

    @GetMapping("/projects/delete/{id}")
    public String deleteProject(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        portfolioService.deleteProject(id);
        redirectAttributes.addFlashAttribute("success", "Project deleted successfully!");
        return "redirect:/admin";
    }

    // Skills
    @GetMapping("/skills/new")
    public String newSkill(Model model) {
        model.addAttribute("skill", new Skill());
        return "admin/skill-form";
    }

    @GetMapping("/skills/edit/{id}")
    public String editSkill(@PathVariable Long id, Model model) {
        model.addAttribute("skill", portfolioService.getSkillById(id));
        return "admin/skill-form";
    }

    @PostMapping("/skills/save")
    public String saveSkill(@ModelAttribute Skill skill, RedirectAttributes redirectAttributes) {
        portfolioService.saveSkill(skill);
        redirectAttributes.addFlashAttribute("success", "Skill saved successfully!");
        return "redirect:/admin";
    }

    @GetMapping("/skills/delete/{id}")
    public String deleteSkill(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        portfolioService.deleteSkill(id);
        redirectAttributes.addFlashAttribute("success", "Skill deleted successfully!");
        return "redirect:/admin";
    }

    // Stats
    @GetMapping("/stats/new")
    public String newStat(Model model) {
        model.addAttribute("stat", new Stat());
        return "admin/stat-form";
    }

    @GetMapping("/stats/edit/{id}")
    public String editStat(@PathVariable Long id, Model model) {
        model.addAttribute("stat", portfolioService.getStatById(id));
        return "admin/stat-form";
    }

    @PostMapping("/stats/save")
    public String saveStat(@ModelAttribute Stat stat, RedirectAttributes redirectAttributes) {
        portfolioService.saveStat(stat);
        redirectAttributes.addFlashAttribute("success", "Stat saved successfully!");
        return "redirect:/admin";
    }

    @GetMapping("/stats/delete/{id}")
    public String deleteStat(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        portfolioService.deleteStat(id);
        redirectAttributes.addFlashAttribute("success", "Stat deleted successfully!");
        return "redirect:/admin";
    }
}
