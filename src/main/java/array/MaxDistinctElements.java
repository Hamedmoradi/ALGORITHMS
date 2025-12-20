package array;

import java.util.HashSet;
import java.util.Set;

public class MaxDistinctElements {
    public int maxDistinctElements(int[] nums, int k) {
        Set<Integer> asd = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > k) {
                asd.add(nums[i]);
            }
        }
        return asd.stream().max(Integer::compare).get() - k;
    }

    public static void main(String[] args) {
        MaxDistinctElements maxDistinctElements = new MaxDistinctElements();
        System.out.println(maxDistinctElements.maxDistinctElements(new int[]{1, 2, 2, 3, 3, 4}, 2));
    }
}
