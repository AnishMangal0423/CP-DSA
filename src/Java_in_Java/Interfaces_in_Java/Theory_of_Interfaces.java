package Java_in_Java.Interfaces_in_Java;

public class Theory_of_Interfaces {

    public static void main(String[] args) {

 /**
  *
  * Q1. what is Interfaces ?
  * Ans:- Interface ek chizz h , jiske saree methods, abstarct hote h .. do system mai communicate krwata h .. 100% abstraction
  *       ki gureente deta h , hme pta h fly kr sakta h kyuki defn likhi hui h  pata nhi kese bas karta h , fly krwana implement krwane wala jane.
  *       Saath mai iske khud chmatkari properties bhi h .. wo ekdum last mai dekhenge.
  *
  *
  *
  * Q2. How to define Interfaces ?
  * Ans:- Bilkul class ki trah hi hota h ..
  *          - Modifier ( sirf public , default hi ho sakta h.. nested mai saab ho sakte h )
  *          - "interface" keyword .
  *          - Interface ka naam.
  *          - comma seperated bhaut saree interfaces bhi ho sakte h.
  *          - Body.
  *
  *
  *
  *Q3. Interface ka itna Haua kyu bnaya hua h ?
  *Ans:- Ye 3 Main chizee krta h -
  *      1. 100% Abstarction.
  *      2. Polymorphism.
  *      3. Multiple Inheritance.        ( Socho 3 properties mai to ghus gya , Kitna Imp hoga)
  *
  *      1. 100% Abstarction -  Simple si baat h ki interface ke pass saree methods abstarct hote h .. aab jisko concrete bn na
  *                             Hoga wo sabko hi implement krti h , to hmne to sarri properties, bhagwaan jane class kese likhegi
  *                             onko .. to 100% hua to abstarction hi.. bird fly, eat, repeat krta h ye to pta hi h .. kese ke lena dena nhi h.
  *
  *
  *      2. Run Time Polymorphism :- 1000 classes ho sakti h , aur 1 method esa h jo sabke pass h , interface se .. to hmm ose
  *                                 interfacse ki madad se implement kra sakte h .. aur fir jis class ka obj chaiye osi hisab se
  *                                 print bhi kr skate h.
  *
  *      3. Multiple Inheitance :- Mera to maan na h ki cpp ka multiple inheritance aadhora h ..
  *                                Eg :-  Purana-phone + camera + mediaPlayer + vedioCalls = Smart-Phones
  *                                C++ is kheta h ki camera hi smart phone h , vediocalls hi smart-phones h.
  *                                aur java kheta h , purana-phone ek samrt phone h and kabhi kabhi camera ki trah bhi kaam
  *                                karta h , aur kabhi kabhi media player ki trah .. matlab extends, implements ki tune pakadna.
  *                                Aab class ek hi extend ho sakti h par interfacses 10^5 tk ho sakte h .
  *                                Matlab aab Ambhiian at a time living i trah bhi h khali, terestial ki trah bhi h , aqautic bhi h .. 1 at a time.
  *                                Yhi hota h multiple Imheritance.
  *                                Class ek se jada nhi ho sakti extend, interface 10^5 ho sakte h.
  *                                Multiple class se to inherit nhi kr payee par interfacse se hoya aur aacha bhi h sun nai mai .. rather then all class implementing it .as in cpp.
  *
  *
  *
  * Q4. Hii Anish, So what about Variables and Methods in Interface ?
  * Ans:- Variables :-   Okay to ye thoda sa Interfaces ka Cringe h ki , Interface ke variables , Khud se hi Static and final hote h
  *                     They are like constats , height , PIE, and all
  *                     Interface a{
  *                        int X = 10;  == same as , static final int X = 10;
  *                       }
  *
  *                     you have to write it in UPPERCASE Letters.
  *
  *
  *      Methods :- Hamare Interfaces ke Methods kabhi final nhi ho sakte and static bhi nhi , bcz of No body.
  *                  Private, Protected isliye use krne mai dikkat h ki onka interface se hi Bhaar nhi h access.
  *
  *
  *
  * ------------------------------------------------------------------------------------------------------------------
  *
  *   Difference b/w Abstarct class and Interfaces.
  *
  *                Abstract Classes                                                Interfaces
  *              ......................                                          ..............
  *  1. Keyword used here id "abstract"                               1. Keyword used here is "interfaces"
  *  2. child Classes "extends"                                       2. Child classes "extends"
  * *3. It can have abstarct and Non abstarct                         3. It can only have Abstarct fns (till java 7)
  *     methods both (so flexible)
  *  4. It can be extend from another classes                         4. Only be extended by interfaces.
  *     and interfaces
  *
  *  5. Variables can be static, non-static,                          5. Variables are static and final as Constants.
  *     final, non-final.
  *
  *  6. Variables and Methods can be Priavte, Public,                 6. All things are public and in Java 9 , private is
  *     Protected and all..                                              also allowed.
  *
  *  7. Multiple Inheritance not supported.                           7. Multiple Inheritance supported.
  *  8. It can have Constructor.                                      8. Not have Constructor.
  *
  *
  *
  * Abstarct classes ka obj to nhi bnta par , onki extended class ka obj bn sakta h , to isliye constructor hota h
  * onke pass.
  *
  *
  *
  * FunFact-
  *       Absatct class 1   , Abstarct class 2    --> Class extending both
  *       void display(){--}  void dispaly(){--}      It will already give error because 2 classes can't be extended.
  *                                                   but we can also override the method.
  *
  *
  *      Interface 1,            Interface 2             --> class Extending both.
  *       display(){              display(){         Will not give error. and will work fine
  *      // Have body           // Have body               we can override method display(), according to use
  *      }                      }
  *
  *                             ----> Main difference in between two.
  *
  *
  *  Interface --> Interface   --> extends is used.
  *  class    --> Class        --> extends is used.
  *  class --> Interface       --> Implements is used.
  *
  *
  * If any Function in interface has body also , then it will be --> default, static or private, because all these 3
  * types can have body from java 8, 9.
  * Isliye laya gya tha ki kisi interface se 1000 class connecetd, h aur agar ek bhi method new baad mai add kr diya
  * to aab kese implement krenge isliye hmne default lagake body bna di oski.. aab jise alag krna hoga override kr lega.
  *
  *
  *
  *
  *
  * **/
    }
}
