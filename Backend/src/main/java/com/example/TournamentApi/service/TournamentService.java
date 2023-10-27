package com.example.TournamentApi.service;

import com.example.TournamentApi.model.TournamentApi;
import com.example.TournamentApi.repository.TournamentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Service
@CrossOrigin(origins = "http://localhost:4200")
public class TournamentService {

    private TournamentRepository tournamentRepository;

    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public TournamentApi getdetails(int id){
        return tournamentRepository.findById(id).get();
    }

    public String postdetails(TournamentApi tournamentApi){
        tournamentRepository.save(tournamentApi);
        return "Successfully posted";
    }

    public String updatedetails(TournamentApi tournamentApi){
        tournamentRepository.save(tournamentApi);
        return "Successfully updated";
    }

    public String deletedetails(int id){
        tournamentRepository.deleteById(id);
        return "Successfully deleted";
    }

    public List<TournamentApi>getalldetails(){
        return tournamentRepository.findAll();
    }

    private void resetAutoIncrementCounter() {
        String sqlQuery = "ALTER TABLE Tournament_details AUTO_INCREMENT = 1";
    }
    public String deletealldetails(){
        tournamentRepository.deleteAll();
        resetAutoIncrementCounter();
        return "All datas deleted";
    }
}
