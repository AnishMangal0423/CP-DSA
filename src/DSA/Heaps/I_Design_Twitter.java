package DSA.Heaps;


import java.util.*;
import java.util.HashMap;
import java.util.PriorityQueue;

class TwitterPair{
    int timer;
    int tweetId;

    TwitterPair(int t, int tweetId){
        this.timer = t;
        this.tweetId = tweetId;
    }
}
class Twitter{

    HashMap<Integer , ArrayList<TwitterPair>> Tweetsmap;
    HashMap<Integer , ArrayList<Integer>> Followmap;
    int time = 0;

    Twitter(){
        Tweetsmap = new HashMap<>();
        Followmap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {

         if(Tweetsmap.containsKey(userId)==true){
             ArrayList temp = Tweetsmap.get(userId);
             temp.add(new TwitterPair(time , tweetId));
             Tweetsmap.put(userId , temp);
             time++;
         }

         else{
             ArrayList<TwitterPair>temp = new ArrayList<>();
             temp.add(new TwitterPair(time , tweetId));
             Tweetsmap.put(userId , temp);
             time++;
         }
    }

    public void follow(int followerId, int followeeId) {

        if(Followmap.containsKey(followerId)==true){
            ArrayList<Integer>temp = Followmap.get(followerId);
            temp.add(followeeId);
            Followmap.put(followerId , temp);
        }

        else{

            ArrayList<Integer>temp = new ArrayList<>();
            temp.add(followeeId);
            Followmap.put(followerId , temp);
        }
    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<TwitterPair>pq = new PriorityQueue<>((a, b)->{
            if(a.timer!=b.timer)return b.timer-a.timer;
            else return b.tweetId-a.tweetId;
        });

        ArrayList<Integer>followList = Followmap.get(userId);
        followList.add(userId);

        for(int Followings : followList){
           ArrayList<TwitterPair>temp = Tweetsmap.get(Followings);
           for(TwitterPair p : temp)pq.add(p);
        }

       List<Integer>ans = new ArrayList<>();

        while (!pq.isEmpty()){
            TwitterPair pp = pq.poll();
            ans.add(pp.tweetId);
        }

        return ans;
    }

    public void unfollow(int followerId, int followeeId) {

        ArrayList<Integer>temp = new ArrayList<>();
        for(int val : Followmap.get(followerId)){
            if(val!=followeeId && val!=followerId)temp.add(val);
        }

        Followmap.put(followerId , temp);
    }




}
public class I_Design_Twitter {

    public static void main(String[] args) {

        Twitter account1 = new Twitter();
        account1.postTweet(1, 4);
        account1.postTweet(1, 5);
        account1.postTweet(1, 10);
        account1.postTweet(2, 12);
        account1.postTweet(2, 1);
        account1.follow(1, 2);
        System.out.println(account1.getNewsFeed(1));
        account1.unfollow(1, 2);
        System.out.println(account1.getNewsFeed(1));
//        System.out.println(account1.Tweetsmap);

        System.out.println("Strting the Account 2 ?: ");
        Twitter account2 = new Twitter();
        account2.postTweet(1, 5);
        account2.postTweet(2,6);
        account2.follow(1, 2);
        account2.follow(2, 1);
        System.out.println(account2.getNewsFeed(1));
        System.out.println(account2.getNewsFeed(2));
    }
}
