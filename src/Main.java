
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] arrayNumbers = new Integer[1_000_0000];
        Character[] arrayChar = new Character[1_000_0000];
        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayChar[i] = (char) random.nextInt(0, 65536);
            arrayNumbers[i] = random.nextInt(0, 100_000);
//            arrayChar[i] = 1;
//            arrayNumbers[i] = 1;
        }

        int sum2 = 0;
        long starTime1 = System.nanoTime();
        for (int i = 0; i < arrayNumbers.length; i++) {//Cравнение без hashCode
            if (Integer.valueOf(arrayChar[i]).equals(arrayNumbers[i])) {
                sum2++;
            }
        }
        long endTime1 = System.nanoTime();
        System.out.println("Количество совпадений = " + sum2 + "\nВремя работы без сравнения hashCode: " + ((endTime1 - starTime1) / 1_000));
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
    }

}
