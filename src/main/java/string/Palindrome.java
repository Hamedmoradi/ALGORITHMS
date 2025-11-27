package string;

public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.trim().toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        int j = s.length()-1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            j--;
        }
        return true;
    }

    //faster solution
//    public boolean isPalindrome(String s) {
//        int left = 0, right = s.length() - 1;
//
//        while (left < right) {
//            char a = s.charAt(left);
//            char b = s.charAt(right);
//
//            // Convert uppercase to lowercase
//            if (a >= 'A' && a <= 'Z') a = (char)(a + 32);
//            if (b >= 'A' && b <= 'Z') b = (char)(b + 32);
//
//            // Skip non-alphanumeric
//            if (!((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))) {
//                left++;
//                continue;
//            }
//            if (!((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))) {
//                right--;
//                continue;
//            }
//
//            // Compare
//            if (a != b) return false;
//
//            left++;
//            right--;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome("A man, a plan, a scanal: Panama"));

    }
}
