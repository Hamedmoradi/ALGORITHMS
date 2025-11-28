package array;

import java.util.Arrays;

public class ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] con = new int[2 * nums.length];
        int index = 0;
        for (int i = 0; i < con.length; i++) {
            if(i<nums.length){
                con[i] = nums[i];
            }else {
                con[i] =nums[index++];
            }
        }
        return con;
    }
//    public int[] getConcatenation(int[] nums) {
//        int n = nums.length;
//        int[] ans = new int[2*n];
//        for (int i=0;i<2*n;i++) {
//            ans[i] = nums[i%n];
//        }
//        return ans;
//    }

    public static void main(String[] args) {
        ConcatenationOfArray c = new ConcatenationOfArray();
        System.out.println(Arrays.toString(c.getConcatenation(new int[]{1,2,3,4})));
    }
}
