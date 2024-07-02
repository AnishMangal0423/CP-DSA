package System_Design.K_BookMyShow.Movies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieController {

    public HashMap<String , List<Movies>>moviesMap;
    public MovieController(){

        moviesMap = new HashMap<>();
    }


    public void addMovies(Movies movie, String city){

        List<Movies>movieList = moviesMap.getOrDefault(city, new ArrayList<>());
        movieList.add(movie);
        moviesMap.put(city,movieList);
    }
}
