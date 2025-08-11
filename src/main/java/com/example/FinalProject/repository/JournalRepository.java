package com.example.FinalProject.repository;

import com.example.FinalProject.model.Journal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface JournalRepository extends JpaRepository<Journal, Long> {

    @Query("SELECT j FROM Journal j WHERE j.userID = ?1 order by date desc")
    List<Journal> findByUser(Integer userID);

    @Query("SELECT j FROM Journal j WHERE j.date = ?1 order by date desc")
    Optional<Journal> findByDate(LocalDate date);
}
