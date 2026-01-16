package PatternsDSA.SlidingWindow.Patterns.Pattern_B;

public class Notes {

    public static void main(String[] args) {

        /***
         *
         * First of all this is the most common Pattern that is observed in 2 Pointer Problems
         * where size of window is not fixed, and we use dynamic window works and the concept of
         * shrink and expand came.
         * shrink means --> l is moving forward.
         * expand means --> r is moving forward.
         *
         *There are Three Approaches to do these types of problems.
         * 1. Brute force.  -> O(n ^ 2)
         * 2. Better approach.  -> O(2n)
         * 3. Optimal Approach.  -> O(n)
         *
         * The Pattern Template is : If you want to feel this template take copy-pen and start dry run then you will be in more joy.
         *
         * Step-1 : Declaration of Variables l, r, maxlen, sum etc.. ---> Declaration Time.
         *
         * Step-2 : Use Loop & Calculate sum because this is the deciding factor to increase length --> Loop & Calcuate Sum Time.
         *
         * Step-3 : Time to print the answer if sum comes in range sum and expand the window. --> Printing ans & Expand Window Time.
         *
         * Step-4 : Now if sum > k , time to shrink the window and move l forward till sum <=k and then again process started --> Shrinking Phase
         *          A -> In Better Approach we will shrink l until sum <=k and then move forward.
         *          B -> In Optimal Approach we are focusing on maxlen as this is our ans at the end of day, so why to decrease the l till last or r ,
         *               just do only l++ if required because we have calculated maxlen at a certain time and r is moving forward every time.
         *
         *
         *
         * **/
    }
}
