package Java_in_Java.Oops_in_Java.Encapsulation;

/**
 *
 * So class is Capsule and some functions are buttons by which you change some internal Circuits ..
 * Data hiding and class str / security.
 *
 * **/
class Employee {
    private String Employee_Name;
    private int salary;


   void setter(String Name , int salary){

       this.Employee_Name = Name;
       this.salary = salary;

   }

   String Name_getter(){
       return this.Employee_Name;
   }

   int Salary_getter(){
       return this.salary;
   }

}
public class Example{

    public static void main(String[] args) {

        Employee e1 = new Employee();
        Employee e2 = new Employee();

        e1.setter("Anish" , 1000000);
        e2.setter("Harish" , 1000);

        System.out.println(e2.Name_getter());
        System.out.println(e2.Salary_getter());

        System.out.println(e1.Name_getter());
        System.out.println(e1.Salary_getter());

    }
}
