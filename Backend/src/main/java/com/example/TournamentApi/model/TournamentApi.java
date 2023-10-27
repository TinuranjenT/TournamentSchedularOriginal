package com.example.TournamentApi.model;

import jakarta.persistence.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name="Tournament_details")
@CrossOrigin(origins = "http://localhost:4200")

public class TournamentApi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String team1;
    private String team2;
    private String date;

    public TournamentApi(int id, String team1, String team2, String date) {
        this.id = id;
        this.team1 = team1;
        this.team2 = team2;
        this.date = date;
    }

    public TournamentApi() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

//    public void save(TournamentApi tournamentApi) {
//    }
}
