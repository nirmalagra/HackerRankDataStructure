import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {

        for(int i=1; i<arr.length; i++){
            int value = arr[i];
            int j =i;
            while(j>0 && arr[j-1]>value){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = value;
        }
        int minDiff = arr[1]-arr[0];
        for(int i =2; i< arr.length; i++){
            if((arr[i]-arr[i-1])<minDiff){
                minDiff = arr[i]-arr[i-1];
            }
        }
        ArrayList<Integer> minDiffList = new ArrayList<>();
        for(int i =1; i< arr.length; i++){
        if((arr[i]-arr[i-1])==minDiff){
            minDiffList.add(arr[i-1]);
            minDiffList.add(arr[i]);
        }
        }

        int[] minDiffArray = new int[minDiffList.size()];
        for(int j = 0; j<minDiffList.size(); j++){
            minDiffArray[j] = minDiffList.get(j);
        }


    return minDiffArray;

    }

    static void printArray(int[] arr){
        for(int i =0; i< arr.length; i++){
            System.out.print(arr[i]+"\t");
        }
            System.out.print("\n");

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
