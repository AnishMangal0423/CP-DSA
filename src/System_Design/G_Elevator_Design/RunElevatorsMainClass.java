package System_Design.G_Elevator_Design;

import System_Design.G_Elevator_Design.Building.Building;

import java.util.Scanner;

public class RunElevatorsMainClass {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("How many Floors are there in Your Building :- ");
        int NumofFloors = sc.nextInt();
        Building MangalamAnanda = new Building(NumofFloors);

        System.out.println("Now it is Time TO GO and Make Requests to any Elevators/Lifts -");

        for (int i=0; i<5; i++) {
            MangalamAnanda.CompleteAllRequestsofUsers();
        }


    }
}
