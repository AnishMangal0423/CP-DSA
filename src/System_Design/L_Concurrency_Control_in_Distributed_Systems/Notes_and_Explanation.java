package System_Design.L_Concurrency_Control_in_Distributed_Systems;

public class Notes_and_Explanation {

/***
 *
 * So we will discuss About Very Important Topic Known as Maintaining the Concurrency in Transactaions while Maintaing
 * the Consistency in Databases.
 *
 * Okay so Transactions and concurancy ko samajane se phle Phle hme ye Samajna hoga ki Problems Kya h -
 *
 * Problem Statement -> Dikkat ye h ki Chayee read Operation Ho ya Write Operation Ho agar Database mai ek operation ek
 *                      Time Par krenge too 100000 operation Hongi hi nhi , serially Hmm nhi Kar payenge , so task is
 *                      Ki hmm concurrant Transactions Kr payee over the one Database.
 *
 *  Some Important Terms Now -
 *   1. Distributed Systems --> Hota Kya h Normally Har api ke liye there is a Load Balancer , and then we mades the copies
 *                              of a server/database and You can Change it Basically Microservice with the help of
 *                              Load Balancer.
 *
 *
 *   2. Transaction --> It is an Action which basically Changes the State of Database and Maintains the Consistent
 *                      Behaviour in Database , Before and after.
 *
 *
 *   3.  Distributed Concurrency Control --> Hota kya h , ki har computer ek system h too hmm bol rhe h har computer ek dusre
 *                                           se networks se jude hue h , and there is a single database among them
 *                                           resource sharing and all.. Aab hmm bol rhe h ki ye saree distributed systems
 *                                           jab change kre to shared resource Consistent rhe , ladaii isi ki h.
 *                                                                            Jab bhauat saree transactions cncurrently work
 *                                           kre and And shared resource should be in consistent state.
 *
 *       And it has 2 parts ..
 *         a. Optimistic Concurrency Control.
 *         b. Pessimistic Concurrency Control.
 *         Inke Baree mai thodi derr mai baat krte h.
 *
 *
 *   Agar Hmm ye dono baat ache se Samaj jayenge to Bhaut assan Ho Jayega Optimistic and Pessimistic Ko Samajna.
 *
 *  # Concept - DB Locking-
 *    DB Locking ki Madad se Hamari ye help hoti h ki, Koi bhi another transaction Locked row par Changes nhi kr sakta.
 *
 *    Theek h to Aab DataBase ke pass 2 trah ke Locks Hote h -
 *    1. Shared Locks --> Ye Read se Lagta h.
 *
 *   2. Exclusive Locks --> Ye Write operation se Lagta h.
 *
 *   Aab ek Relation h..
 *
 *   If Shared Lock is Present ---> Another Shared Lock (ok)  , Exclusive Lock (No)   [Means read me read ho sakta h , write nhi]
 *
 *   If Exclusive Lock is Present --> Any Shared Lock (No)   , Any Other Exclusive Lock (No)   [write mai na another write na read]
 *
 *
 *   ## Isolation Levels Present in a Databases-
 *      There are 4 Levels of Isolation in Database-
 *      1. Read Uncommited.
 *      2. Read Commited.
 *      3. Repeatable Read.
 *      4. Serializable.
 *
 *      But Before Deep Dive into Levels we will Discuss Some General Problems which occurs in Databases Changes.
 *
 *      1. Dirty Read Problem --> Hota Kya h let's Suppose 2 Transactions h , T1, T2.. Aab lets suppose database mai a=20 pda
 *                                tha, kisi time pe T2 nai ose change kreke 30 kr diya aur commit nhi kiya aur bhaisaab T1 ne value ko
 *                                Pda to 30 h aur Commit kr diya , Baad mai T2 nai value ko 40 kr diya aur fir commit kiya
 *                                So overall T1 ek dirty value of Read kr rha h. so this is Known as Dirty read Problem.
 *                                Like exam mai ek bachaa dusre ki mai se tep rha hoo.
 *
 *
 *       2. Non-Repeatable Read Problem --> Isme Kya hota h lets suppose T1, T2 H and t1 ne phle value read ki 20 aayi , fir bhai t2 nai 30
 *                                          kr diya , to jab t1 ne read ki too value 30 aayi fir 40 bhi aa sakti h ,
 *                                          To value Reapet nhi ho rhi h , alag alag aa rhi h ..
 *
 *
 *       3. Phantom Read Problem --> Hota Kya h ki Lets suppose T1 ne kha esi value read krunga jo 1 se badi  and 5 se chooti hoo.
 *                                   and maan lo bich mai kisi ne write krke ek aur entry Ghusa di is Range Value ki.
 *
 *                                   TO Ye Teen trah ki Read Problems h.
 *
 *
 *        Aab Firse Isolation Levels Par aate h..
 *
 *
 *      1. Read Uncommited Isolation Level --> Hota kya h Ki isme Koi bhi Lock nhi hota h , Chayee Koi Read Operation Aaye ya, write operttion
 *                                             Jab chayee tab aake kuch bhi kr sakte h .. To ese cases mai Sirf Read only operations ke liye
 *                                             Hi isko use kiya jata h, Use- like anylsis of Data and all..
 *
 *                                             Dirty Read - Yes
 *                                             Non-Repeat - Yes.
 *                                             Phantom - Yes
 *
 *      2. Read Commited Isolation Level --> Isme Kya Hota h , Ki Shared Lock accquired and Released as soon as Read operation is done.
 *                                           and agar Exlxulsive write lock lag gya too fir wo transaction khatam hone tak kisi
 *                                           Lock ko Nhi aane dega.
 *
 *                                           Dirty Read - No ( Kyuki hamesha commited value hi read hogi)
 *                                           Non-Reapeat - Yes. ( 2 value to mil hi jayegi , commit ke baad alag)
 *                                           Phantom - Yes .
 *
 *      3. Repeatable Read Isolation Level --> Isme Kya hota h ki jo Shared Locks hote h wo bhi tab hi remove hote h jab Transaction
 *                                             Complete ho and same with Exclusive Locks also. Too overall Baat ye h ki lets suppose
 *                                             Irctc wale h wo kisi row par tab hi chnage krenge jab ose Koi read nhi kr rha hoga..
 *                                             and koi user tab hi read krega jab maintainer saree changes complete kr chuke honge...
 *                                             Means Less concurrancy but high consistency.
 *
 *                                             Dirty Read - No
 *                                             Non-Repeat - No
 *                                             Phantom - Yes.
 *
 *
 *       4.
 *
 *
 *
 *
 *
 *
 *
 * **/
}
