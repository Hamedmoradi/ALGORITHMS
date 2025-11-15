package array.move_zeroes;

import java.util.Arrays;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        MoveZeroes solution = new MoveZeroes();
        solution.moveZeroes(new int[]{0, 1, 0, 3, 12});
    }
}
