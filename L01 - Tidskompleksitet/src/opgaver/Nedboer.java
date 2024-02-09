package opgaver;

import java.util.Arrays;

public class Nedboer {
    private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13,
        15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18, 23, 12, 0, 2, 0, 0, 78, 0,
        0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18,
        19, 21, 32, 24, 13 };

    public static void main(String[] args) {
        Nedboer nedboer = new Nedboer();
        System.out.println(nedboer.count());
        System.out.println("ugenummer for minimal nedbørsmængde i tre uger: " + "uge " + nedboer.bedsteTreFerieUger());
        System.out.println("ugenummer for minimal nedbørsmænde i vilkårligt antal uger: " + "uge " + nedboer.bedsteFerieUgerStart(5));
        System.out.println("ugenummer på første uge med præcis samme mængde nedbør i flest dage: " + "uge " + nedboer.ensNedboer());
    }

    public int count() {
        int count = 0;
        for (int i = 0; i < nedboerPrUge.length; i++) {
            count++;
        }
        return count;
    }

    public int max() {
        int max = 0;
        int index = 0;
        for (int i = 0; i < nedboerPrUge.length; i++) {
            if (nedboerPrUge[i] > max) {
                max = nedboerPrUge[i];
                index = i;
            }
        }
        return index;
    }

    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i de tre uger
     *
     * @return
     */

    public int bedsteTreFerieUger() {
        int sum = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < nedboerPrUge.length - 2; i++) {
                int currentSum = nedboerPrUge[i] + nedboerPrUge[i + 1] + nedboerPrUge[i + 2];

                if (currentSum < sum ) {
                    sum = currentSum;
                    index = i;
                }
            }
        return index;
    }

    /**
     * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien,
     * hvis man ønsker den minimale nedbørsmængde i det "antal" uger, der er
     * angivet i paramtereren
     *
     * @return
     */

    public int bedsteFerieUgerStart(int antal) {
        int sum = Integer.MAX_VALUE;
        int index = 0;

        for (int i = 0; i < nedboerPrUge.length - antal; i++) {
            for (int j = 0; j < antal; j++) {
                int currentSum =+ nedboerPrUge[i + j];

                if (currentSum < sum ) {
                    sum = currentSum;
                    index = i;
                }
            }
        }
        return index;
    }

    /**
     * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis
     * den samme flest uger i træk
     *
     * @return
     */
    public int ensNedboer() {
        int highest = 0;
        int current = 0;
        int ugenr = 0;

        int i = 0;
        while (i < nedboerPrUge.length - 1 && highest > i - nedboerPrUge.length - 1) {
            int j = 0;
            while (nedboerPrUge[i + j] == nedboerPrUge[i + j + 1]) {
                current++;
                j++;
            }
            if (current > highest) {
                highest = current;
                ugenr = i;
            }
            i += current == 0 ? 1 : j;
            current = 0;
        }
        return ugenr + 1;
    }
}



//public int ensNedboer() {
//    int max = 0;
//    int index = 0;
//
//    for (int i = 0; i < nedboerPrUge.length; i++) {
//        int count = 0;
//        for (int j = i + 1; j < nedboerPrUge.length; j++) {
//            if (nedboerPrUge[i] == nedboerPrUge[j]) {
//                count++;
//            }
//        }
//        if (count > max) {
//            max = count;
//            index = i;
//        }
//    }
//    return index;
//}

//int[] arr = new int[100];
//
//        for (int value : nedboerPrUge) {
//arr[value]++;
//        }
//
//int max = 0;
//int most = 0;
//
//        for (int i = 0; i < nedboerPrUge.length; i++) {
//int count = 0;
//                if (nedboerPrUge[i] > max) {
//max = nedboerPrUge[i];
//count++;
//most = i;
//            }
//
//                    }
//                    return most;