package com.example.TournamentApi.controller;

import com.example.TournamentApi.model.TournamentApi;
import com.example.TournamentApi.service.TournamentService;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tournament")
@CrossOrigin(origins = "http://localhost:4200")
public class TournamentController {
    @Autowired

    private TournamentService tournamentService;

    @GetMapping("{id}")
    public TournamentApi getdetails(@PathVariable("id") int id){
        return tournamentService.getdetails(id);
    }

    @GetMapping
    public List<TournamentApi> getalldetails(){
        return tournamentService.getalldetails();
    }


    @PostMapping
    public String postdetails(@RequestBody TournamentApi tournamentApi){
        tournamentService.postdetails(tournamentApi);
        return "Successfully posted";
    }

    @PutMapping
    public String updatedetails(@RequestBody TournamentApi tournamentApi){
        tournamentService.updatedetails(tournamentApi);
        return "Successfully updated";
    }

    @DeleteMapping("{id}")
    public String deletedetails(@PathVariable("id") int id){
        tournamentService.deletedetails(id);
        return "Successfully deleted";
    }

    @DeleteMapping
    public String delete(){
        tournamentService.deletealldetails();
        return "All details deleted";

    }




}
