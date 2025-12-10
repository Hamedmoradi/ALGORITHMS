package string;

public class StringSegment {
    public int countSegments(String s) {
        if (s == null || s.isEmpty() || s.trim().isEmpty()) {
            return 0;
        }
        String[] s1 = s.trim().split(" ");
        int count = 0;
        for (String string : s1) {
            if (string != null && !string.isEmpty() && !string.trim().isEmpty()) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        StringSegment s = new StringSegment();
        System.out.println(s.countSegments(", , , ,        a, eaefa"));
    }
}
