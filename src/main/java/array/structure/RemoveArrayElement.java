package array.structure;

import java.util.Scanner;

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
Return k.
*/
public class RemoveArrayElement {
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
        System.out.println(RemoveArrayElementSolution.removeElement(arr, target));

    }
}

class RemoveArrayElementSolution {
    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
    }

