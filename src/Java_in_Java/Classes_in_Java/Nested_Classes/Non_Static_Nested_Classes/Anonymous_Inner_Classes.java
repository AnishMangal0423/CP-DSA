package Java_in_Java.Classes_in_Java.Nested_Classes.Non_Static_Nested_Classes;

abstract class Hospital{
    abstract void ICUWard();
}

public class Anonymous_Inner_Classes{

    public static void main(String[] args) {

        Hospital h = new Hospital() {
            @Override                            // Anonmously obj is created and method is also defined
            void ICUWard() {                    // abstract class ke naam pe hi le liya.
                System.out.println("I a in ICU Ward");
            }
        };
    }
}
