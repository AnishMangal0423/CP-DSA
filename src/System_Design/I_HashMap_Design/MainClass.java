package System_Design.I_HashMap_Design;

public class MainClass {

    public static void main(String[] args) {

        HashMap<Integer, String>map = new HashMap<>();

        System.out.println("Actual Size of Maps is :- "+map.size());
        map.put(1, "Anish");
        map.put(2, "Suresh");
        map.put(3, "Mahesh");
        map.put(4, "Ganesh");
        map.put(5, "Ganesh");
        map.put(6, "Ganesh");
        map.put(7, "Ganesh");
        map.put(8, "Ganesh");
        map.put(9, "Ganesh");


        System.out.println(map.get(1));
        System.out.println(map.get(3));
        System.out.println(map.get(4));
    }
}
