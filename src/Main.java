import java.sql.Time;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Timer;

import static java.util.Arrays.*;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] arrayNumbers = new Integer[1_000_0000];
        Character[] arrayChar = new Character[1_000_0000];
        for (int i = 0; i < arrayNumbers.length; i++) {
//            arrayChar[i] = (char) random.nextInt(0, 1);
//            arrayNumbers[i] = random.nextInt(0, 1);
            arrayChar[i] = 1;
            arrayNumbers[i] = 1;
        }
        int sum1 = 0;
        long starTime2 = System.nanoTime();
        for (int i = 0; i < arrayNumbers.length; i++) { // Cравнение через hashCode
            if (arrayChar[i].hashCode() == arrayNumbers[i].hashCode()) {
                if (Integer.valueOf(arrayChar[i]).equals(arrayNumbers[i])) {
                    sum1++;
                }
            }
        }
        long endTime2 = System.nanoTime();
        System.out.println("Количество совпадений  = " + sum1 + "\nВремя работы c сравнением hashCode: " + ((endTime2 - starTime2) / 1_000));
        int sum2 = 0;
        long starTime1 = System.nanoTime();
        for (int i = 0; i < arrayNumbers.length; i++) {//Cравнение без hashCode
            if (Integer.valueOf(arrayChar[i]).equals(arrayNumbers[i])) {
                sum2++;
            }
        }
        long endTime1 = System.nanoTime();
        System.out.println("Количество совпадений = " + sum2 + "\nВремя работы без сравнения hashCode: " + ((endTime1 - starTime1) / 1_000));
    }

}

//    public static String printTextPerRole(String[] roles, String[] textLines) {
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < roles.length; i++) {
//            sb.append(roles[i] + ":");
//            for (int j = 0; j < textLines.length; j++) {
//                if (textLines[j].subSequence(0,textLines[j].indexOf(':')).equals((roles[i]))) {
//                    sb.append("\n" + (j + 1) + ")" + textLines[j].substring(textLines[j].indexOf(':') + 1));
//                }
//            }
//            sb.append("\n\n");
//        }
//        //Твой код здесь
//        return String.valueOf(sb);
//    }
//    public static String printTextPerRole1(String[] roles, String[] textLines) {
//
//        StringBuilder sb = new StringBuilder();
//        String a1 = new String("foo");
//        String a2 = new String("bar");
//        System.out.println(a2.equals(a1) +" " + a2.hashCode());
//        for (int i = 0; i < roles.length; i++) {
//            sb.append(roles[i] + ":");
//            for (int j = 0; j < textLines.length; j++) {
//                if (textLines[j].subSequence(0,textLines[j].indexOf(':')).equals((roles[i]))) {
////                    sb.append("\n" + (j + 1) + ")" + textLines[j].substring(textLines[j].indexOf(':') + 1));
//                    sb.append("\n");
//                    sb.append(j+1);
//                    sb.append(")");
//                    sb.append(textLines[j].substring(textLines[j].indexOf(':') + 1));
////                    sb.append("");
////                    sb.append("");
////                    sb.append("");
////                    sb.append("");
//                }
//            }
//            sb.append("\n\n");
//        }
//        //Твой код здесь
//        return String.valueOf(sb);
//    }
//
//}
//    public boolean equals(Object anObject) {
//        if (this == anObject) {
//            return true;
//        }
//        return (anObject instanceof String aString)
//                && (!COMPACT_STRINGS || this.coder == aString.coder)
//                && StringLatin1.equals(value, aString.value);
//    }
//public int hashCode() {
//    int h = hash;
//    if (h == 0 && !hashIsZero) {
//        h = isLatin1() ? StringLatin1.hashCode(value)
//                : StringUTF16.hashCode(value);
//        if (h == 0) {
//            hashIsZero = true;
//        } else {
//            hash = h;
//        }
//    }
//    return h;
//}