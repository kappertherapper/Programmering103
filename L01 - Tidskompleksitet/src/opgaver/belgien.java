package opgaver;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class belgien implements Comparator<Character> {
    public static void main(String[] args)  {
        Character[] flag = {'G', 'R', 'S', 'G', 'G', 'R', 'S', 'R', 'G', 'G', 'R', 'S', 'G'};

        belgisk_flag(flag);

        System.out.println(Arrays.toString(flag));

    }

    public static void belgisk_flag(Character[] belgisk_flag) {
        Comparator<Character> customComparator = (c1, c2) -> {
            if (c1 == 'S') {
                return -1;
            } else if (c2 == 'S') {
                return 1;
            } else if (c1 == 'G' && c2 != 'S') {
                return -1;
            } else if (c2 == 'G' && c1 != 'S') {
                return 1;
            } else {
                return Character.compare(c1, c2);
            }
        };

        // Sorter arrayet ved hjælp af den brugerdefinerede komparator
        Arrays.sort(belgisk_flag, customComparator);
    }

    @Override
    public int compare(Character o1, Character o2) {
        if (o1.equals("S")) {
            return -1; // "s" kommer før alle andre bogstaver
        } else if (o2.equals("S")) {
            return 1; // "s" kommer efter alle andre bogstaver
        } else if (o1.equals("G") && !o2.equals("S")) {
            return -1; // "g" kommer før alle andre bogstaver undtagen "s"
        } else if (o2.equals("G") && !o1.equals("S")) {
            return 1; // "g" kommer efter alle andre bogstaver undtagen "s"
        } else {
            return o1.compareTo(o2); // Resten af bogstaverne sorteres ved hjælp af compareTo
        }
    }
}




//for (int i = 0; i < belgisk_flag.length; i++) {
//        if (belgisk_flag[i] == 'G') {
//belgisk_flag[i] = 'S';
//        } else if (belgisk_flag[i] == 'R') {
//belgisk_flag[i] = 'G';
//        } else if (belgisk_flag[i] == 'S') {
//belgisk_flag[i] = 'R';
//        }
//        }


//Comparator<Character> custom = Comparator.comparingInt(c -> {
//    if ('s' == c) {
//        return 103;
//    } else if ('g' == c) {
//        return 114;
//    } else if ('r' == c) {
//        return 115;
//    } else {
//        throw new IllegalArgumentException("Unexpected value: " + c);
//    }
//});
//
//        Arrays.sort(belgisk_flag, custom);





//
//
//
//Comparator<Character> custom = Comparator.comparingInt(c -> {
//    if ('s' == c) {
//        return 103;
//    } else if ('g' == c) {
//        return 114;
//    } else if ('r' == c) {
//        return 115;
//    } else {
//        throw new IllegalArgumentException("Unexpected value: " + c);
//    }
//});
//
//var characters = new String(belgisk_flag).chars()
//        .mapToObj(c -> (char) c)
//        .toArray(Character[]::new);
//
//        Arrays.sort(characters, 0, belgisk_flag.length, Comparator.comparingInt(c -> {
//        if (c.equals('S')) {
//        return -1; // "s" kommer før alle andre bogstaver
//        } else if (c.equals('G')) {
//        return 1; // "s" kommer efter alle andre bogstaver
//        } else if (c.equals('R')) {
//        return 2;
//        } else {
//        throw new IllegalArgumentException("Unexpected value: " + c);
//            }
//                    }));
//
//                    Arrays.sort(belgisk_flag);