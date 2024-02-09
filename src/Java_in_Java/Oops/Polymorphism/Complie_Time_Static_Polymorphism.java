package Java_in_Java.Oops.Polymorphism;


/**
 *
 * Benefit of Overloading is we have not to make seperate buttons for all functionality , just make 1 named button and
 * use in many form by no of arguments just .. esay for developer .. less named fns.
 *
 *
 * Compiler already knows how much memory to give and  all.
 *
 *
 * Yeah object creation happens at run time but reference pointer is made and memory is allocated to fns.and calls.
 * **/
class Empoyee{

    String Name;
    int salary;
    String workingHours;


    public void Display(String N, int salary){
        System.out.println("Name of Employee is : "+N);
        System.out.println("Salary of "+N+" is: "+salary);
    }


    public void Display(String N, int salary, int w){
        System.out.println("Name of Employee is : "+N);
        System.out.println("Salary of "+N+" is: "+salary);
        System.out.println("Working Hours of "+N+" is: "+w);

    }


}

public class Complie_Time_Static_Polymorphism{

    public static void main(String[] args) {


        Empoyee e1 = new Empoyee();
        e1.Display("Anish", 10000);
        e1.Display("Anisha" , 10000000, 10);

    }
}
