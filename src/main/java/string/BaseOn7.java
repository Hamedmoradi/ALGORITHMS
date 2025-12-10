package string;

public class BaseOn7 {

    //    public String convertToBase7(int num) {
//        return Integer.toString(num, -7);
//    }
    public String convertToBase7(int num) {
        int remain;
        boolean sign = false;
        String r = "";
        if (num < 0) {
            sign = true;
        }
        num = Math.abs(num);
        while (num >= 7) {
            remain = num % 7;
            num = num / 7;
            r = r.concat(String.valueOf(remain));
        }
        r = r.concat(String.valueOf(num));
        r = reverse(r);
        if (sign) {
            r = "-".concat(r);
        }
        return r;
    }

    private String reverse(String input) {
        char[] a = input.toCharArray();
        int l;
        int r;
        r = a.length - 1;

        for (l = 0; l < r; l++, r--) {
            char temp = a[l];
            a[l] = a[r];
            a[r] = temp;
        }
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        BaseOn7 baseOn7 = new BaseOn7();
        System.out.println(baseOn7.convertToBase7(-7));
    }
}
