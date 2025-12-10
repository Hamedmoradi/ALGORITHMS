package string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        return String.valueOf(Long.sum(Long.parseLong(num1), Long.parseLong(num2)));
    }

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        System.out.println(addStrings.addStrings("3876620623801494171", "6529364523802684779"));
    }
}
