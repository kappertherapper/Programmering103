package streams.exercises1;

import java.util.*;
import java.util.stream.Collectors;

public class Exercises1 {

    public static void main(String[] args) {
        // Liste med tal mellem 1 - 50
        List<Integer> list = List.of(1,2,3,2,1,6,3,4,5,2,3,8,8,9,34,32);
        list.stream().forEach(e -> System.out.println(e + 1));


        //	Udskriver det største element i listen
        list.stream()
                .max(Integer::compareTo);

        //	Afgør og udskriver om alle tallene i listen er mindre end 50
        list.stream()
                .filter(number -> number.intValue() < 50)
                .forEach(System.out::println);

        // 	Udskriver antallet af lige tal i listen
        list.stream()
                .filter(number -> number.intValue() % 2 != 0)
                .forEach(System.out::println);

        //	Udskriver antallet af ulige tal i listen
        list.stream()
                .filter(number -> number.intValue() % 2 == 0)
                .forEach(System.out::println);

        //  Udskriver
        //      Gennemsnittet af tallene i listen
        list.stream()
                .mapToInt(Integer::intValue)
                .average();

        //      Antallet af tallene i listen
        list.stream().count();

        //      Antallet af tallene i listen der er større end gennemsnittet
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> list.stream()
                                .filter(number -> number > avg)
                                .forEach(System.out::println));
        //      Antallet af tallene i listen der er mindre end gennemsnittet
        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(avg -> list.stream()
                        .filter(number -> number < avg)
                        .forEach(System.out::println));

        //  TODO
        //	Udskriver antallet af gange de forskellige tal forekommer i listen


        //  TODO
        //	Udskriver antallet af gange de forskellige tal forekommer i listen i sorteret orden
    }
}
