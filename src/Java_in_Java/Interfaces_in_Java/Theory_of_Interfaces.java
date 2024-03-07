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
  * **/
    }
}
