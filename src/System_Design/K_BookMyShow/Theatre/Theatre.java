package System_Design.K_BookMyShow.Theatre;

import System_Design.K_BookMyShow.Screen.Screen;

import java.util.List;

public class Theatre {

   public int TheatreId;
    public String TheatreName;

    public String TheatreAddress;

    public List<Screen>screensList;

    public void setTheatreId(int id){
        this.TheatreId=id;
    }

    public int getTheatreId(){
        return TheatreId;
    }

   public void setTheatreName(String name){
        this.TheatreName=name;
    }

   public String getThreatreName(){
        return TheatreName;
    }

    public void setScreen(List<Screen>list){
        this.screensList=list;
    }

    public List<Screen> getScreens(){
        return this.screensList;
    }

    }

