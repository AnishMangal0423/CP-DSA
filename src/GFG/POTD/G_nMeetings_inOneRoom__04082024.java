package GFG.POTD;

import java.util.*;
import java.util.Scanner;

class MeetingsPair{

    int start;
    int end;

    MeetingsPair(int s, int e){
        this.start=s;
        this.end=e;
    }
}
public class G_nMeetings_inOneRoom__04082024 {

    public static int MaxMeets(int n, int[]start, int[]end) {

        MeetingsPair[] newarr = new MeetingsPair[n];

        for (int i = 0; i < n; i++) {
            newarr[i] = new MeetingsPair(start[i], end[i]);
        }

        Arrays.sort(newarr, (a, b) -> {
                    if (a.end != b.end) return a.end - b.end;
                    else return a.start - b.start;
                }
        );


        int finishTime = -1;
        int MeetCount = 0;
        for(int i=0; i<n; i++){

            MeetingsPair p = newarr[i];
            int startTime = p.start;
            int endTime = p.end;

            if(startTime > finishTime){
                finishTime = endTime;
                MeetCount++;
            }
        }
return MeetCount;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int[]start = new int[n];
        int[]end = new int[n];

        for(int i=0; i<n; i++)start[i] = sc.nextInt();
        for(int j=0; j<n; j++)end[j] = sc.nextInt();


        System.out.println("Maximum Number of Meetings are :? " + MaxMeets(n, start, end));
    }
}
