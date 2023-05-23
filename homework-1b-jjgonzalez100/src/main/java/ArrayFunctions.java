public class ArrayFunctions {

    public static double averageOfEvens(int[][] numbers) {
        int total = 0;
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                if (numbers[i][j] % 2 == 0) {
                    count++;
                    total = numbers[i][j] + total;
                }

            }
        }
        double average = total / count;
        return average;
    }

    public static double averageOfEvens(int[][] arraysOfNums, int[] numArray) {
        int total = 0;
        int count = 0;

        for(int i = 0; i < arraysOfNums.length; i++) {
            for(int j = 0; j < arraysOfNums.length; j++) {
                if(arraysOfNums[i][j] % 2 == 0) {
                    count++;
                    total = arraysOfNums[i][j] + total;
                }
            }
        }

        for(int i = 0; i < numArray.length; i++) {
            if(numArray[i] % 2 == 0) {
                count++;
                total = numArray[i] + total;
            }
        }
        double average = total / count;
        return average;
    }

    public static int countWordsStartingWithChar(String[] words, char found) {
        int count = 0;

        for(int i = 0; i < words.length; i++) {
            if(words[i].charAt(0) == found) {
                count++;
            }
        }
        return count;
    }

    public static int[] flattenArray(int[][] ragged) {
        int count = 0;

        for(int i = 0; i < ragged.length; i++) {
            for(int j = 0; j < ragged[i].length; j++) {
                count++;
            }
        }

        int index = 0;
        int[] linear = new int[count];

        for(int i = 0; i < ragged.length; i++) {
            for(int j = 0; j < ragged[i].length; j++) {
                linear[index] = ragged[i][j];
                index++;
            }
        }
        return linear;
    }
}
