package array;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationSum {
    /*
          This problem can be solved using dynamic programming. We can create an array dp of size target + 1, where dp[i]
          will store the number of combinations that add up to i. The base case is dp[0] = 1 since there is one way to make
          a sum of 0, which is using no elements.
          For each element num in nums, we iterate through i from num to target, and for each i, we add dp[i - num]
          to dp[i]. This is because if we can make a sum i - num with some combination, we can make a sum i by
          adding num to that combination.
          The time complexity of this algorithm is O(target * nums.length), and the space complexity is O(target).
        */
    public static int combinationSum(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (i - num >= 0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        System.out.println(dp[target]);
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner1.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = scanner2.nextInt();
        combinationSum(numbers, target);
    }
}
