package com.example.FinalProject.service;

import com.example.FinalProject.model.Mood;
import com.example.FinalProject.repository.MoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class MoodService {
    @Autowired
    private MoodRepository moodRepository;
    public List<Mood> getAllMoods() {
        return moodRepository.findAll();
    }
    public Optional<Mood> getMoodById(Long id) {
        return moodRepository.findById(id);
    }
    public Mood saveMood(Mood mood) {
        return moodRepository.save(mood);
    }
    public Mood updateMood(Long id, Mood updatedMood) {
        return moodRepository.findById(id).map(mood -> {
            mood.setUserID(updatedMood.getUserID());
            mood.setMoodvalue(updatedMood.getMoodvalue());
            mood.setDate(updatedMood.getDate());
            return moodRepository.save(mood);
        }).orElse(null);
    }

}
