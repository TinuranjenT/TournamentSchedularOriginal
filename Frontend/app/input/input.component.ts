import { Component } from '@angular/core';
import{HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.scss']
})

  export class InputComponent {
    constructor(private http: HttpClient){

    }
    newTeamName!:string;
    teams:any=[];
    data:any=[];
    //matches:String[]=[];
    matches:any=[];
   //matches: Match[]=[];
    startingDate:Date=new Date();
    error:String=' ';
    success:String=' ';

  
    addTeam() {
      if (this.newTeamName.trim() !== '') {
        this.teams.push(this.newTeamName);
        this.newTeamName = '';
       
        }
      //   for(let i of this.teams){
      //     console.log(i);
      // }
    }
    deleteTeam(){
      this.teams.pop();
    }

    getData(){
      this.http.get('http://localhost:8080/tournament').subscribe((data)=>{
        this.data=data;
        console.warn(data); 
      })
      }

    generateMatchSchedule(startingDate: Date){
      
        this.http.delete('http://localhost:8080/tournament').subscribe(response=>{
          console.log("Previous data deleted", response);

        })
      let currentDate=new Date(this.startingDate);
      let date_string:any=currentDate.toString();
      console.log(date_string);
      this.matches=[]; //empty the array
      const numberofTeams=this.teams.length;
      console.log(numberofTeams+" teams");
      if(numberofTeams<2){
        this.error="Please add atleast two teams";
      }

      for(let i=0; i<numberofTeams; i++){
        for(let j=i+1; j<numberofTeams; j++){
          const team1=this.teams[i];
          const team2=this.teams[j];
          const match = {team1: team1, team2: team2, matchDate:date_string};
          this.matches.push(match); 
          console.log(match);
          this.http.post('http://localhost:8080/tournament', match).subscribe(response=>{
          console.log('Data sent successfully', response);
          })
    }
    //console.log(this.matches);
    
    }
  }
}


