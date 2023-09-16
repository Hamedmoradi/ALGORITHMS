package array;

import java.util.Scanner;

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.
*/
public class TwoSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the length of array:");
        int length = scanner.nextInt();
        System.out.println("enter the array elements:");

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            Scanner s3 = new Scanner(System.in);
            arr[i] = s3.nextInt();
        }
        System.out.println("please enter the target sum result:");
        int target = scanner.nextInt();
        int[] resultArray = TwoSumSolution.twoSum(arr, target);
        for (int i = 0; i < resultArray.length; i++) {
            System.out.println(resultArray[i]);
        }
    }
}

class TwoSumSolution {
    public static int[] twoSum(int[] nums, int target) {
        int[] array = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target && i != j) {
                    array[0] = i;
                    array[1] = j;
                    return array;
                }
            }
        }
        return null;
    }
}