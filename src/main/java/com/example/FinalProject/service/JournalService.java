package com.example.FinalProject.service;

import com.example.FinalProject.model.Journal;
import com.example.FinalProject.repository.JournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JournalService {
    @Autowired
    private JournalRepository journalRepository;
    public List<Journal> getAllJournals() {
        return journalRepository.findAll();
    }
    public Optional<Journal> getJournalById(Long id) {
        return journalRepository.findById(id);
    }
    public Journal saveJournal(Journal journal) {
        return journalRepository.save(journal);
    }
    public Journal updateJournal(Long id, Journal updatedJournal) {
        return journalRepository.findById(id).map(journal -> {
            journal.setUserID(updatedJournal.getUserID());
            journal.setContents(updatedJournal.getContents());
            journal.setDate(updatedJournal.getDate());
            return journalRepository.save(journal);
        }).orElse(null);
    }

    //public Journal findByUser(Integer userID) {
    //    return journalRepository.findByUser(userID);
    //}

}
