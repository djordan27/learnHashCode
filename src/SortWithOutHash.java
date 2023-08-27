public class SortWithOutHash {
    private Integer[] arrayNumbers;
    private Character[] arrayChar;

    public SortWithOutHash(Integer[] arrayNumbers, Character[] arrayChar) {
        this.arrayNumbers = arrayNumbers;
        this.arrayChar = arrayChar;
    }

    public int sort() {
        int sum1 = 0;
        for (int i = 0; i < arrayNumbers.length; i++) { // Cравнение через hashCode

            if (Integer.valueOf(arrayChar[i]).equals(arrayNumbers[i])) {
                sum1++;

            }
        }
        return sum1;
    }
}

