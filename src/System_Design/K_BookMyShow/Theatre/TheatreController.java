package System_Design.K_BookMyShow.Theatre;

import System_Design.K_BookMyShow.Movies.Movies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheatreController {

    HashMap<String , List<Theatre>>TheatreMap;

    public TheatreController(){

        this.TheatreMap=new HashMap<>();
    }

    public void addTheatres(Theatre theatre, String city){

        List<Theatre>theatresList = TheatreMap.getOrDefault(city, new ArrayList<>());
        theatresList.add(theatre);
        TheatreMap.put(city,theatresList);
    }
}
