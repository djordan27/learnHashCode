
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class    Main {
    public static void main(String[] args) {
        Random random = new Random();
        Integer[] arrayNumbers = new Integer[1_000_0000];
        Character[] arrayChar = new Character[1_000_0000];
        for (int i = 0; i < arrayNumbers.length; i++) {
            arrayChar[i] = (char) random.nextInt(0, 100000);
            arrayNumbers[i] = random.nextInt(0, 100000);
//            arrayChar[i] = 1;
//            arrayNumbers[i] = 1;
        }


        int sum1 = 0;
        long starTime2 = myNanotime();
        for (int i = 0; i < arrayNumbers.length; i++) { // Cравнение через hashCode
            if (arrayChar[i].hashCode() == arrayNumbers[i].hashCode()) {
                if (Integer.valueOf(arrayChar[i]).equals(arrayNumbers[i])) {
                    sum1++;
                }
            }
        }
        long endTime2 = myNanotime();
        System.out.println("Количество совпадений  = " + sum1 + "\nВремя работы c сравнением hashCode в main: " + ((endTime2 - starTime2) / 1_000));
        int sum2 = 0;
        long starTime1 = System.nanoTime();
        for (int i = 0; i < arrayNumbers.length; i++) {//Cравнение без hashCode
            if (Integer.valueOf(arrayChar[i]).equals(arrayNumbers[i])) {
                sum2++;
            }
        }
            long endTime1 = myNanotime();
        System.out.println("Количество совпадений = " + sum2 + "\nВремя работы без сравнения hashCode в main: " + ((endTime1 - starTime1) / 1_000));
        long starTime3 = myNanotime();
        int sum3 = new SortHash(arrayNumbers,arrayChar).sort();
        long endTime3 = myNanotime();
        System.out.println("Количество совпадений = " + sum3 + "\nВремя работы c сравнением hashCode: " + ((endTime3 - starTime3) / 1_000));
        long starTime4 = myNanotime();
        int sum4 = new SortWithOutHash(arrayNumbers,arrayChar).sort();
        long endTime4 = myNanotime();
        System.out.println("Количество совпадений = " + sum4 + "\nВремя работы без сравнения hashCode: " + ((endTime4 - starTime4) / 1_000));
    }

    public static long myNanotime(){
        long time = 0;
        for (int i = 0; i < 100000; i++) {
            time+=System.nanoTime();
        }
        time /=100000;
        return time;
    }

}
