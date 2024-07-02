package System_Design.K_BookMyShow.user;

import java.util.List;
import java.util.Scanner;

import System_Design.K_BookMyShow.Movies.MovieController;
import System_Design.K_BookMyShow.Movies.Movies;
import System_Design.K_BookMyShow.Theatre.TheatreController;

public class user {

    String name;

    int id;
    MovieController movieController;
    TheatreController theatreController;


    String location;

    Scanner sc = new Scanner(System.in);
    public user(String name, int id, MovieController movieController, TheatreController theatreController, String location){

        this.id=id;
        this.name = name;
        this.movieController=movieController;
        this.theatreController=theatreController;
        this.location=location;

        SearchMovies();
    }

    private void SearchMovies() {

        System.out.println("All Available Movies in - " + location+ " are : " + movieController.moviesMap.get(location));
        System.out.println("Enter the Movie that You want to watch : ");
        String movieNameChoosen = sc.next();


    }
}
