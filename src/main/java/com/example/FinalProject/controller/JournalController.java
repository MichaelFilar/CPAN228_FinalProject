package com.example.FinalProject.controller;

import com.example.FinalProject.model.Journal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.FinalProject.repository.JournalRepository;

import java.util.Date;

@Controller
@RequestMapping("/journals")
public class JournalController {

    private final JournalRepository journalRepository;

    public JournalController(JournalRepository journalRepository) {this.journalRepository = journalRepository;}

    @GetMapping
    public String list(Model model) {
        model.addAttribute("journals", journalRepository.findAll());
        return "journal";
    }

    @PostMapping("/add")
    public String saveJournal(@ModelAttribute Journal journal) {
        journal.setDate(new Date());
        journal.setUserID(123L);
        journalRepository.save(journal);
        return "redirect:/journals";
    }
}
