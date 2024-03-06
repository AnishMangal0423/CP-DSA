package Java_in_Java.Classes_in_Java;

public class Important_Theory {
    public static void main(String[] args) {

        /***
         *
         *
         * 1. Concrete Classes --> a. These are those classes of which we can always create the objects by New Keyword.
         *   ...................   b. All the Methods in this Class have Implementation. (No defns Allowed).
         *                         c. Let suppose we have child class that Implements the Interfaces or child class
         *                            that extends the base case, if it had all fns complete then it is Concrete.
         *                         d. A class access Modifier can be Public or default(package private).
         *
         *
         *  2. Abstract Classes --> a. The abstract classes are Represented By Abstract Keyword before the class.
         *   ...................    b. Abstarct class ke pass ho sakta h ki abstarct fn ho bhi sakte h aur nhi bhi.
         *                          c. lekin agar kisi class mai kisi fn ki body nhi h too ose abstarct hona padega.
         *                          d. Abstarct classes bani hi inherit hone ke liye h , aab jo class ose inherit kr rhi
         *                             h agar saree fns ko declare kr deti h tab to concrete ho jayegi aur object bn sakta h
         *                             nhi to osme bhi hme aage concrete likhna padega.
         *                          e. Kabhi bhi Abstarct class final to nhi hogi.. kyuki final inherit nhi hone dega class
         *                             ko , aur abstarct to bna hi inherit hone ke liye h.
         *                          f. Ek point yaad rkh skate h ki abstarct classes static nhi hoti kyuki inner classes hi ho skti h.
         *                          g. Abstract methods , final nhi ho skate h .. same reason.
         *                          h. Abstarct methods , static bhi nhi ho skate kyuki fn defn hi nhi hota, koi direct call na karde.
         *
         *
         * 3. Sub Class and Super Class --> Isko samajne se phle hme ye samajna hoga ki sub class ka matlab child classes
         *   ...........................    Hota h aur , super class ka matlab parent class hota h .. to har class ka koi
         *                                  na koi parent hota hi h , jiska koi parent explicitly nhi h oska parent bhi
         *                                  Object class hoti h , aur hmm jo bhi fns usme defined hote h , jese toString()
         *                                  notifyAll(),, ese functions ko jab marzi use kr sakte h , by object class Refrence.
         *
         *
         * 4. Nested Classes  --> Nested Classes are of 2 Types -
         *   ..................    a. Static Nested Classes.
         *                         b. Non-static Netsed Classes (Inner Classes)
         *                             aa. Local Inner Classes.
         *                             bb. Member Inner Classes.
         *                             cc. Anynomous Inner Classes.
         *
         *
         *                             Class within the another Class is Known as Nested Class.
         *                             Java mai hme Pta h ki hrr class ki ek file bnti h , let suppose class a is inside b
         *                             ya too dono ko alag bnado , ya fir hme pata h ki sir class b hi a ko use krti h system
         *                             mai to, alag se file bna ne ki wajaah hmm nesting use kr lete h.
         *
         *
         *        a. Static Nested Class --> a. Jo ander ki nested static class h osko bhaar outer class ke non-static memebers
         *          ......................      Access karne ka koi hakk nhi h.
         *                                   b. Ye Baat thodi ajeeb h lekin , hmm bhaar wali class ke object bnaye bina hi , sidha
         *                                      ander ki class ka object bnakar ander ke methods access kr sakte h.
         *                                      Thoda olta h , ek tarah se ye samaj lo static bhaar wali class par likha h.
         *                                   c. Bhaar wali class to sirf, public ya default hi ho sakti h par, ander wali jo class h wo
         *                                      public, private, protected, defaul sab ho sakti h .. socho ander bnana h ya nhi ye to
         *                                      sab possible h hi..
         *                                   d. Jo baat mene ajjeb woli h , wo mene aache se explain kri h static nested ke demo1 mai..
         *
         *
         *         b. Non-Static Nested --->  a. Sbse phle to Bhaar ke variables ho ya ander ke sarree variables hi hmm log access kr
         *           ....................        sakte h.
         *             Inner Classes          b. Bas object bhar ka bna na padega , fir osi obj se ander obj bna na padega
         *              ba  or Member Claases    fir ander ke methods call kar skate h.
         *                    ...............
         *
         *
         *   Note --> Inner Class ko hi Non static nested ko hi inner khte h , aur Normal wali jo hiti h wo hi member class hoti h.
         *
         *
         *                        bb. Local Inner Classes  -->1.  Inner Classes which are defined in any block of function, if-else
         *                           .....................        or for loop
         *
         *                                                    2. No, private, public, protected is used for Local inner classes , only defalut is allowed.
         *                                                       Kyuki block ke logo ko private bolke koi sense hi nhi h wo to khud hi private, protected and all, no public.
         *
         *
         *                        bc. Anonomys Inner Class -->  Hota h kya h ki abstarct classes aur interfaces to bluprint sa dete h
         *                          ......................      aab hamari responsibility h ki onhe ek class bnake implement kre.. iski
         *                                                      bajay ye bhi kr sakte h ki hmm class bnaye hi na os class ka sidha hi
         *                                                      obj bnaye aur jo bhi fn override krna ho wo bhi declaration ke sath hi krde
         *                                                      kitna easy hoga.. file bhi nhi banegi ,.. aur feel bhi hoga.
         *                                                      Internally hota whi h jo basics h par os anonmous class ka namm $ jesa kuch hota h.
         *
         *
         *
         *
         * 5. Singleton Classes  --->  ye classes hoti h jiska sirf or sirf , ek hi obj ho sakta h , aab aap osi obj par jitni
         *  ....................       chayee otni quriers chla sakta hein .. aur agar dusra obj bna ne ki koshish kari to osi
         *                             obj ka refernce mil jayega jo phle tha ..
         *                             Iska jadatar use Database connection mai kiya jata h like one time connection and then raise quieries
         *                             We can use this single object repeatedly as per the requirements. This is the reason why multi-threaded
         *                             and database applications mostly make use of the Singleton pattern in Java for caching, logging, thread pooling,
         *                             configuration settings, and much more.
         *
         *                             Do tarike se ho sakta h -
         *                             1. Eager Intilization --> bas obj phle se hi defined h , to agar call nhi kra to faltu mai
         *                                                       hi obj bn gya.
         *
         *                             2. Lazy Intilization --> Isme jab call kroge tab hi phla obj bnega , 2nd obj creation to dono
         *                                                      mai hi whai refernce pass kar dega.
         *
         *                            3. Synchorinization Bock.
         *                            4. Double check Lock.
         *                            5. Bill Pugh Solution.      --> Not so Imp for Juniors.
         *                            6. Enum Singleton.
         *
         *
         * 6.Immutable classes  --->   The concept of Immutable came into picture when once an Object is Created it's values
         * .....................       can't be Changed. (Due to security Reasons and all).
         *                             Demo I have Showed You.
         *
         *
         * 7.Wrapper Classes -->
         *
         *
         *
         *
         *
         *
         * **/
    }
}
