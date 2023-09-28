package string;

import java.util.Arrays;
import java.util.Scanner;

import static string.AddTwoBinaryStrings.addBinary;


public class AddTwoBinaryStrings {
    static String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        int sum = 0;
        StringBuilder result = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            sum = carry;
            if (i >= 0) sum = sum + a.charAt(i) - '0';
            if (j >= 0) sum = sum + b.charAt(j) - '0';
            result.append((char) (sum % 2 + '0'));
            carry = sum / 2;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}

class AddTwoBinaryStringsSolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        System.out.print(addBinary(a, b));
    }
}
