package System_Design.K_BookMyShow;

import System_Design.K_BookMyShow.Movies.MovieController;
import System_Design.K_BookMyShow.Movies.Movies;
import System_Design.K_BookMyShow.Screen.Screen;
import System_Design.K_BookMyShow.Theatre.Theatre;
import System_Design.K_BookMyShow.Theatre.TheatreController;
import System_Design.K_BookMyShow.user.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BookMyShow {

    public MovieController movieController = new MovieController();
    public TheatreController theatreController = new TheatreController();
    Scanner sc = new Scanner(System.in);
    public void initilize(){

        // Now i will Initilize all the things-

        System.out.println("Starting the Book My Show App ....");
        createMovies();

        System.out.println("Enter the Name of User - ");
        String name = sc.next();
        System.out.println("Enter Your Current Location "+ name);
        String location = sc.next();

        user user1 = new user(name, 1,movieController, theatreController, location);
    }

    public void createMovies(){

        String city1 = "Bangalore";
        Movies movie1 = new Movies(1, "Bahubali", 2);
        Movies movie2 = new Movies(2, "Dil Bechara", 3);
        Movies movie3 = new Movies(3, "Dangal", 2);
        Movies movie4 = new Movies(4, "12thFail", 2);
        movieController.addMovies(movie1, city1);
        movieController.addMovies(movie2, city1);
        movieController.addMovies(movie3, city1);
        movieController.addMovies(movie4, city1);


        String city2 = "Mumbai";
        Movies movie5 = new Movies(1, "Chris3", 2);
        Movies movie6 = new Movies(2, "Conjoring", 3);
        Movies movie7 = new Movies(3, "Euro-Trip", 2);
        Movies movie8 = new Movies(4, "Sex-Education", 2);
        movieController.addMovies(movie5, city2);
        movieController.addMovies(movie6, city2);
        movieController.addMovies(movie7, city2);
        movieController.addMovies(movie8, city2);

        createTheaters();
    }

    public void createTheaters(){

        String city1 = "Bangalore";
        String city2 = "Mumbai";
        Theatre theatre1 = new Theatre();
        theatre1.setTheatreId(1);
        theatre1.setTheatreName("INOX");
        theatre1.setScreen(createScreen());

        Theatre theatre2 = new Theatre();
        theatre1.setTheatreId(2);
        theatre1.setTheatreName("PVR");

//        Theatre theatre2 = new Theatre(2, "INOX", "Bangalore");
//        Theatre theatre3 = new Theatre(3, "Cinepolis", "Bangalore");
//        Theatre theatre4 = new Theatre(4, "Vinayak Cinema", "Mumbai");
//        Theatre theatre5 = new Theatre(5, "Divine", "Mumbai");
        theatreController.addTheatres(theatre1, city1);
        theatreController.addTheatres(theatre2, city2);
//        theatreController.addTheatres(theatre3, city1);
//        theatreController.addTheatres(theatre4, city2);
//        theatreController.addTheatres(theatre5, city2);
//        theatre1.addScreen(1, 200);
//        theatre1.addScreen(2, 300);


    }

    public List<Screen> createScreen(){

        List<Screen>list = new ArrayList<>();
        Screen s1 = new Screen();
        s1.setScreenName("Screen-1");
        s1.SetScreenId(1);
        s1.SetnoofSeats(100);

        Screen s2 = new Screen();
        s2.setScreenName("Screen-2");
        s2.SetScreenId(1);
        s2.SetnoofSeats(100);

        list.add(s1);
        list.add(s2);

        return list;
    }


}







































