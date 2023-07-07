package array.subArrayDivision;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class ResultPlusMinus {


    /*
     * https://www.hackerrank.com/challenges/plus-minus/problem?isFullScreen=false
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
        // Write your code here
        Float p = 0f;
        Float z = 0f;
        Float n = 0f;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 0) {
                z++;
            } else if (arr.get(i) < 0) {
                n++;
            } else {
                p++;
            }
        }
        System.out.println(String.format("%.6f", p / arr.size()));
        System.out.println(String.format("%.6f", n / arr.size()));
        System.out.println(String.format("%.6f", z / arr.size()));
    }

}

class SolutionPlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        ResultPlusMinus.plusMinus(arr);

        bufferedReader.close();
    }
}