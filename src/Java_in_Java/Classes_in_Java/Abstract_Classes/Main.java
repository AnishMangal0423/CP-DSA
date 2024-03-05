package Java_in_Java.Classes_in_Java.Abstract_Classes;

abstract class Hospital{

    void EmergencyWard(){
        System.out.println("We are emergency ward");
    }

    abstract void ICUWard();
    abstract void Reception();
}

class MyHospital extends Hospital{

    @Override
    void ICUWard(){
        System.out.println("We are in ICU Ward");
    }

    @Override
    void Reception(){
        System.out.println("We are in Reception ");
    }
}
public class Main{
    public static void main(String[] args) {

        MyHospital h = new MyHospital();
        h.ICUWard();
        h.Reception();
        h.EmergencyWard();

    }
}
