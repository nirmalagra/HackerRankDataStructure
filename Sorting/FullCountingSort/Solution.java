import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countSort function below.
    static void countSort(List<List<String>> arr) {

        int length = arr.size();
        Map<Integer,StringBuilder> indexValuesMap = new TreeMap<>();
        int currIndex= 0;
        for(List<String> list : arr){
            int index = Integer.parseInt(list.get(0));
            String str = list.get(1);
            if(currIndex<length/2){
                    str = "-";
            }

            if(indexValuesMap.containsKey(index)){
                StringBuilder sb = indexValuesMap.get(index);
                sb.append(str+" ");
                indexValuesMap.put(index, sb);
            } else {
                indexValuesMap.put(index,new StringBuilder(str+" "));
            }
            currIndex++;
        }

        
        for (Map.Entry<Integer,StringBuilder> entry : indexValuesMap.entrySet())  {
                System.out.print( entry.getValue());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Arrays.asList(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")));
        }

        countSort(arr);

        bufferedReader.close();
    }
}
