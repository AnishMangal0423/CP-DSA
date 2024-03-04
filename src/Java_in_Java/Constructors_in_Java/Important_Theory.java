package Java_in_Java.Constructors_in_Java;

public class Important_Theory{
    public static void main(String[] args) {

        /***
         *
         *
         *   Q1. Why Constructors Name is Same as Class Name ?
         *   Ans :- 1. Is qn ke ans ko samajne se phle , hme ek concept samajna hoga ki let suppose class ka naam
         *             Employee h to we can also make the functions like void Employee(){} , int Employee(){}
         *             ye java mai allowed h , same class Name ke hi methods bhi bna sakte hoo.
         *
         *          2. But in general log aisa nhi krte They put different name of their methods.. to osi
         *             Ka fayada Java developers bolte h ki we are defining Now the constructor name same as class.
         *             takki constructor ki phechan durr se hi ho jayee ki ye constructor h.
         *
         *
         *
         *   Q2. Why constructors Do Not have Return Type ?
         *   Ans :- 1. Aab hmne ye to sikh liya ki constructors ka name , methods ka name saab ek baar ke liye same
         *             Ho sakte h (in worst case).. to agar socho constructor ka bhi return type hone lag gya to methods
         *             aur constructors mai koi difference bachega ?
         *             isliye they have Not any return type.
         *
         *
         *   Q3. Why we Not uses Final Keyword in Constructor ?
         *   Ans :- In concept to samajne se phle , hme ek baat ye samajni hogi ki .. jab bhi hmm kisi bhi parent class
         *          Ko inherit krte h child class se to parent ke variables, methods ko to copy karte h .. but kabhi bhi
         *          Constructor ko copy nhi kar sakte .. bas object bnta h to wo implicilty call hota h .. copy nhi kabhi bhi
         *          Matlb override Nhi kar sakte h .. jis class ka constructor h wo whai rhega .. warna to constrcutor aur
         *          class Name alag ho jayenge.
         *          Aab final ka asli matlab yhi h ki kisi bhi chizz ko override hone se bachana . par java devlopers ne to
         *          phle se hi constructors ko ye power di h ki tum kabhi override hoge hi nhi to firse final declare kr dena
         *          is like redundancy aur isi liye fir compile time error aati h .. & that's why we not uses final in Constructor.
         *
         *
         *
         *   Q4. Why we cannot use Abstract keyword in Constructor ?
         *   Ans - Abstract ka matlab hota h ki hmm oski body nhi de rhe h .. sirf defination denge .. body jise use karni h
         *         wo khud likhe.. to hmm jante h ki constructor to override hota hi nhi h to hmm oski body baad mai define
         *         bhi nhi kr payenge isi liye hme abhi hi body declare krni padegi & we cannot use abstarct.
         *
         *
         *
         *    Q5. Why Constructors caanot have Static Keyword ?
         *    Ans :- Isko Do tarike se samja ja sakta h ..
         *         1. Socho agar constructor khud hi static ho gya instace ke non-static members ko kon declare krega.
         *
         *         2. Aur dusra Constructor chaining ki dikkat -
         *
         *
         *
         *
         *     Q6. Can Interface have Constructors ?
         *     Ans :- Isko sochne se Phle hme Interface ka real Usage pta hona Chaiye ki Interfaces ka asli use ye tha ki
         *            Hmm kuch definations bna denge taki jise krna h kre aur Multiple Inheritance ho payee.
         *            Lekin hmm Interfaces ka object to bna hi nhi sakte hmm to classes ka objects , bna sakte h sirf
         *            to is baat ka to koi sense hi nhi bnta ki interfaces ko bhi constructors diye jayee.
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         *
         * **/
    }
}
