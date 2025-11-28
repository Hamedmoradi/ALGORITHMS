package string;


public class StringToInteger {

    public int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        long result = 0; // long prevents overflow during calculation

        // 1. Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Check sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }

        // 3. Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = result * 10 + digit;

            // 4. Overflow clamp
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int) (result * sign);
    }

    public static void main(String[] args) {
        StringToInteger solver = new StringToInteger();
        System.out.println(solver.myAtoi("+-12"));        // 0
        System.out.println(solver.myAtoi("   -42"));      // -42
        System.out.println(solver.myAtoi("4193 with"));   // 4193
        System.out.println(solver.myAtoi("words 987"));   // 0
        System.out.println(solver.myAtoi("-91283472332")); // -2147483648
    }
}

