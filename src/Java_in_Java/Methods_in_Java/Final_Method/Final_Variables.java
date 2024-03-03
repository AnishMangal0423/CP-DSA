package Java_in_Java.Methods_in_Java.Final_Method;

/**
 * So the Theory for Final variables is Clear , WhenEver we declared any variable as Final we can't change it's value again.
 * So we can declare final variable as-
 * 1. Instantly on the time of Declaration.
 * 2. By using constructuer,
 * 3. or By making static blocks if we use static final variables.
 *
 *
 *
 * Static final means Like pie value as all obj will use it and we will not chnage it as well.
 * **/
public class Final_Variables{

    int a = 10;
    final static int b = 20;

    final int c;

    Final_Variables(int c){
        this.c = c;
    }
    public static void main(String[] args) {

//       b = 100;    --> Giving error and saying that we can't change the value of B it is Fianl.
    }
}
