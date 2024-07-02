package System_Design.K_BookMyShow.Movies;

import System_Design.K_BookMyShow.Theatre.TheatreController;

public class Movies {

    int Movieid;
    String MovieName;

    int duration;

    TheatreController theatreController;

    public Movies(int MovieId, String movieName, int duration){
        this.Movieid = MovieId;
        this.MovieName = movieName;
        this.duration=duration;
    }

    public void SearchMovies(){

    }
}
