package string;

public class ReverseString {
    public void reverseString(char[] s) {
        int k = 0;
        char temp;
        for (int i = s.length - 1; i > 0 && i >= k; i--) {
            temp = s[i];
            s[i] = s[k];
            s[k] = temp;
            k++;
            if (i - k == 0 || k == i) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
    }
}
