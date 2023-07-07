package array.structure;

public class ArraySample {
    public static void main(String[] args) {
        Array array = new Array(4);
        array.insert(0);
        array.insert(1);
        array.insert(2);
        array.insert(30);
        array.insert(4);

        array.printArray();
        System.out.println("++++++++++++++++++++++++");
        array.removeAt(2);
        array.printArray();
        System.out.println("++++++++++++++++++++++++");
        System.out.println(array.indexOf(30));
        System.out.println("++++++++++++++++++++++++");
        array.reverse();
        array.printArray();




    }
}
