package com.example.FinalProject.controller;

import com.example.FinalProject.model.Journal;
import com.example.FinalProject.repository.JournalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

@Controller
@RequestMapping("/journals")
public class JournalController {

    private final JournalRepository journalRepository;

    public JournalController(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("journals", journalRepository.findByUser(123));
        return "journal";
    }

    @PostMapping
    public String saveJournal(@ModelAttribute Journal inJournal, Model model) {
        if (inJournal.getContents() == null || inJournal.getContents().trim().isEmpty()) {
            model.addAttribute("errorMessage", "Journal content cannot be empty.");
            return "redirect:/journals";
        }

        inJournal.setUserID(123L);
        inJournal.setDate(LocalDate.now());
        Journal dailyJournal = journalRepository.findByDate(LocalDate.now()).orElse(inJournal);
        dailyJournal.setContents(inJournal.getContents());
        journalRepository.save(dailyJournal);

        return "redirect:/journals";
    }
}