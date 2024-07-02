package System_Design.K_BookMyShow.Screen;

import System_Design.K_BookMyShow.Movies.Movies;

import java.util.List;

public class Screen {

    public int ScreenId;

    public String ScreenName;
    public int noOfSeats;

//    Movies movie;
//   List<Shows>shows;
//    public Seats seats;

  public void SetScreenId(int id){
       this.ScreenId = id;
   }

   public int getScreenId(){
       return ScreenId;
   }

   public void SetnoofSeats(int noOfSeats){
       this.noOfSeats=noOfSeats;
   }

  public int getNoOfSeats(){
       return noOfSeats;
   }

   public void setScreenName(String name){
       this.ScreenName=name;
   }

   public String getScreenName(){
       return ScreenName;
   }

}
