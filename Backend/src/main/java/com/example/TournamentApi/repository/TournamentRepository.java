package com.example.TournamentApi.repository;

import com.example.TournamentApi.model.TournamentApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "http://localhost:4200")

public interface TournamentRepository extends JpaRepository <TournamentApi, Integer> {
}
