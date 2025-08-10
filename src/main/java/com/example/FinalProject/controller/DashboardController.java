package com.example.FinalProject.controller;

import com.example.FinalProject.model.Journal;
import com.example.FinalProject.model.Mood;
import com.example.FinalProject.repository.JournalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.FinalProject.repository.MoodRepository;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/")
public class DashboardController {

    private final MoodRepository moodRepository;

    public DashboardController(MoodRepository moodRepository) {this.moodRepository = moodRepository;}

    @GetMapping
    public String home(Model model) {
        model.addAttribute("moods", moodRepository.findByUser(123));
        return "dashboard";
    }

    @PostMapping
    public String mood(@ModelAttribute Mood inMood, Model model) {
        System.out.println("post "+inMood);
        inMood.setUserID(123L);
        inMood.setDate(LocalDate.now());
        Mood dailyMood = (moodRepository.findByDate(LocalDate.now())).orElse(inMood);
        dailyMood.setMoodvalue(inMood.getMoodvalue());
        moodRepository.save(dailyMood);
        return "redirect:/";
    }


}
