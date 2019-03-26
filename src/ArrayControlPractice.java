
public class ArrayControlPractice {

    /**
     * Calculates sum of all even integers <= n
     * @param n         any integer
     * @return sum      the sum of all integers <= n
     */
    public static int sumOfEvenNumbers(int n){
        int sum = 0;
        for (int j=1; j<=n; j++){
            if (j % 2 == 0)
                sum += j;
        }
        return sum;
    }

    /**
     * Determines whether an integer array contains all unique values
     * @param intArray    an integer array
     * @return true       if all integers unique; false if there are duplicates
     */
    public static Boolean allDistinct(int[] intArray){
        for (int j : intArray){
            for (int i=j+1; i<intArray.length; i++){
                if (intArray[j] == intArray[i])
                    return false;
            }
        }
        return true;
    }

    /**
     * Determines max, min, and avg values of an array of double numbers
     * @param numbers       double array of any length
     * @return statsArray   double array with {max, min, avg}
     */
    public static double[] statistics(double[] numbers){
        double max = numbers[0];  // Initialize max with first index in numbers
        double min = numbers[0];  // Initialize min with first index in numbers
        double sum = numbers[0];  // Initialize sum with first index in numbers

        for (int j=1; j<numbers.length; j++){
            if (numbers[j] > max)
                max = numbers[j];  // Assigns current index value to max if it's greater than max
            if (numbers[j] < min)
                min = numbers[j];  // Assigns current index value to min if it's less than min
            sum += numbers[j];     // Adds current index value to sum
        }

        double avg = sum / numbers.length;      // avg is assigned the average of values within numbers array
        double[] statsArray = {max, min, avg};  // statsArray assigned array with max, min, and avg values in numbers
        return statsArray;                      // returns statsArray
    }

    public static void main (String[] args){

        // 2 tests of sumOfEvenNumbers method
        int testSum100 = sumOfEvenNumbers(100);     // returns sum of even integers from 0-100 (inclusive)
        int testSum200 = sumOfEvenNumbers(200);     // returns sum of even ints from 0-200 (inclusive)
        System.out.println("Test sumOfEvenNumbers method");
        System.out.println("Sum of even numbers (n=100): " + testSum100);
        System.out.println("Sum of even numbers (n=200): " + testSum200);

        // 1st test of allDistinct method
        int[] testIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 1, 2, 3, 4};            // integer array with 20 values, some duplicates
        Boolean testDistinct = allDistinct(testIntArray);       // return false if there are duplicates, otherwise true
        System.out.println("\n1st test of allDistinctNumbers method");
        System.out.println("All integers distinct?: " + testDistinct);  // should output "false"

        // 2nd test of allDistinct method
        int[] testIntArray2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20};        // integer array with 20 values, no duplicates
        Boolean testDistinct2 = allDistinct(testIntArray2);
        System.out.println("\n2nd test of allDistinctNumbers method");
        System.out.println("All integers distinct?: " + testDistinct2); // should output "true"

        // first test statistics method
        double[] testDoubleArray = {1.0, 3.0, 4.5, 3.3, 10.2, 11.0, 7.9, 8.8, 2.5, 21.0};
        double[] testStatistics = statistics(testDoubleArray);
        System.out.println("\nTest statistics method (test 1)");
        System.out.println("Max: " + testStatistics[0]);
        System.out.println("Min: " + testStatistics[1]);
        System.out.println("Avg: " + testStatistics[2]);

        // second test of statistics method
        double[] testDoubleArray2 = {5.6, 9.5, 0.3, 34.5, 1.1, 5.0, 17.7, 5.4, 90.0, 2.7};
        double[] testStatistics2 = statistics(testDoubleArray2);
        System.out.println("\nTest statistics method (test 2)");
        System.out.println("Max: " + testStatistics2[0]);
        System.out.println("Min: " + testStatistics2[1]);
        System.out.println("Avg: " + testStatistics2[2]);


    }

}
