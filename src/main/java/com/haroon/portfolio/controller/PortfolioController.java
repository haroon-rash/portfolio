package com.haroon.portfolio.controller;

import com.haroon.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("hero", portfolioService.getHeroSection());
        model.addAttribute("projects", portfolioService.getAllProjects());
        model.addAttribute("skills", portfolioService.getAllSkills());
        model.addAttribute("stats", portfolioService.getAllStats());
        model.addAttribute("contact", portfolioService.getContactInfo());
        return "index";
    }
}
