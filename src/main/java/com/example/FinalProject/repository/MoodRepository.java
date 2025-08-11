package com.example.FinalProject.repository;

import com.example.FinalProject.model.Journal;
import com.example.FinalProject.model.Mood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MoodRepository extends JpaRepository<Mood, Long> {

    @Query("SELECT j FROM Mood j WHERE j.userID = ?1  order by date desc")
    List<Mood> findByUser(Integer userID);

    @Query("SELECT j FROM Mood j WHERE j.date = ?1 order by date desc")
    Optional<Mood> findByDate(LocalDate date);
}
