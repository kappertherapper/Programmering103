package Opgaver;

import java.util.HashSet;

public class App {
    public static void main(String[] args) {
        HashSet<Bil> biler = new HashSet<>();
        Bil bil1 = new Bil("AB12345", "Toyota", "Corolla", "Blå");
        Bil bil2 = new Bil("CD67890", "Ford", "Focus", "Grøn");
        Bil bil3 = new Bil("EF98765", "BMW", "3-serie", "Sort");

        Bil bil4 = new Bil("AB12345", "Toyota", "Corolla", "Blå");
        Bil bil5 = new Bil("CD67890", "Ford", "Focus", "Grøn");
        Bil bil6 = new Bil("EF98765", "BMW", "3-serie", "Sort");

        biler.add(bil1);
        biler.add(bil2);
        biler.add(bil3);

        biler.add(bil4);
        biler.add(bil5);
        biler.add(bil6); // hashcode og equals overskrivet, så disse er de samme som 1,2,3

        System.out.println(biler);





    }
}
