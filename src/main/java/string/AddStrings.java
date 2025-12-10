//package string;
//
//import java.util.Arrays;
//
//public class AddStrings {
//
//    public String addStrings(String num1, String num2) {
//        char[] char_num1 = num1.toCharArray();
//        char[] char_num2 = num2.toCharArray();
//        boolean flag = false;
//
//        if (char_num1.length > char_num2.length) {
//            return Arrays.toString(extracted(num1, num2, flag, char_num1, char_num2));
//        } else {
//            return Arrays.toString(extracted(num2, num1, flag, char_num1, char_num2));
//        }
//
//    }
//
//    private static int[] extracted(String num1, String num2, boolean flag, char[] char_num1, char[] char_num2) {
//        int remainder = 0;
//        int asd = 0;
//        int l1 = char_num1.length - 1;
//        int l2 = char_num2.length - 1;
//        int[] result = new int[Math.max(l1, l2) + 1];
//        int index = result.length - 1;
//        int count = 0;
//        for (; index > 0; index--) {
//            int temp = 0;
//            if (num1.length() >= num2.length() && count < num2.length()) {
//                if (flag) {
//                    temp = char_num1[l1] - '0' + char_num2[l2] - '0' + asd;
//                    asd = 0;
//                } else {
//                    temp = char_num1[l1] - '0' + char_num2[l2] - '0';
//                }
//                if (temp > 9) {
//                    remainder = temp % 10;
//                    asd = temp / 10;
//                    flag = true;
//                    result[index] = remainder;
//                } else {
//                    result[index] = temp;
//                }
//            }
//            if (count > num2.length() - 1 && count < num1.length() - 1) {
//                if (flag) {
//                    result[index] = char_num1[l1] - '0' + asd;
//                    asd = 0;
//                } else {
//                    result[index] = char_num1[l1] - '0';
//                }
//            }
//            if (count < num1.length() && count > num2.length() && flag) {
//                result[index] = char_num2[l2] - '0' + asd;
//            }
//            count++;
//            l1--;
//            l2--;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        AddStrings addStrings = new AddStrings();
//        System.out.println(addStrings.addStrings("3876620623801494171", "6529364523802684779"));
//    }
//}
