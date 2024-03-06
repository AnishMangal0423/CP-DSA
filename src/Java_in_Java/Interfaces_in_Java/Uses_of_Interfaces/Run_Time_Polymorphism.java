package Java_in_Java.Interfaces_in_Java.Uses_of_Interfaces;

interface LivingBeing{
    void canBreathe();
}

class Peacock implements LivingBeing{

    @Override
    public void canBreathe(){
        System.out.println("Yes, Peacock can Breathe.");
    }
}


class Hen implements LivingBeing{

    @Override
    public void canBreathe(){
        System.out.println("Yes, Hen can also Breathe. ");
    }
}

public class Run_Time_Polymorphism {

    public static void main(String[] args) {

        LivingBeing l = new Peacock();
        l.canBreathe();
        l = new Hen();     // It is decidiable at run time that l is point to which object .. so many forms at run time.
        l.canBreathe();
    }
}
