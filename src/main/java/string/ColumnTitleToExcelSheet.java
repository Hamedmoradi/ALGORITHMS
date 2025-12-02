package string;

public class ColumnTitleToExcelSheet {
    public int titleToNumber(String columnTitle) {
        int digit = 0;
        int result = 0;
        int temp;
        char[] chars = columnTitle.toCharArray();
        for (int i = columnTitle.length(); i > 0; i--) {
            temp = (int) (Math.pow(26, digit) * (chars[i - 1] - 'A' + 1));
            result += temp;
            digit++;
        }
        return result;
    }

    public static void main(String[] args) {
        ColumnTitleToExcelSheet obj = new ColumnTitleToExcelSheet();
        System.out.println(obj.titleToNumber("ZY"));
    }
}
