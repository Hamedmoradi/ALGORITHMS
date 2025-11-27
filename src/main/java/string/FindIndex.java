package string;

//Find the Index of the First Occurrence in a String
public class FindIndex {
    public int strStr(String haystack, String needle) {
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }

    public static void main(String[] args) {
        FindIndex findIndex = new FindIndex();
        System.out.println(findIndex.strStr("leetcode", "lee"));
    }
}
