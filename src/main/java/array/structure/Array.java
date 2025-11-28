package array.structure;

public class Array {

    private int count;
    private int[] items;

    public Array(int size) {
        this.items = new int[size];
    }


    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public void reverse() {
        int[] reverse_arr = new int[items.length];
        int j = 0;
        for (int i = items.length - 1; i >= 0; i--) {
            reverse_arr[j] = items[i];
            j++;
        }
        items = reverse_arr;
    }

    public void insert(int value) {
        if (count == items.length) {
            int[] newArray = new int[count * 2];
            for (int i = 0; i < items.length; i++) {
                newArray[i] = items[i];
            }
            items = newArray;
        }
        items[count++] = value;
    }

    public int[] insertAt(int index, int value) {

        if (index >= items.length) {
            int[] newArr = new int[index + 1];
            for (int i = 0; i < newArr.length; i++) {
                if (i == index) {
                    newArr[i] = value;
                } else if (i < items.length) {
                    newArr[i] = items[i];
                }
            }
            items = newArr;
        } else {
            items[index] = value;
        }

        return items;
    }

    public int[] removeElement(int[] numbers, int val) {
        int index = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != val) {
                numbers[index] = numbers[i];
                index++;
            }
            if (index == numbers.length - 1) {
                numbers[index] = 0;
                break;
            }
        }
        return numbers;
    }

    public void printArray() {
        for (int a : items) {
            System.out.println(a);
        }
    }

//1- Extend the Array class and add a new method to return the largest
//    number. What is the runtime complexity of this method?
//    Solution: Array.max()
//2- Extend the Array class and add a method to return the common items
//    in this array and another array.
//    Solution: Array.intersect()


    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(0);
        array.insert(1);
        array.insert(2);
        array.insert(30);
        array.insert(4);

        array.insertAt(6, 60);
        array.insertAt(9, 90);
        array.insertAt(7, 70);
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

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("enter the length of array:");
//        int length = scanner.nextInt();
//        System.out.println("enter the array elements:");
//
//        int[] arr = new int[length];
//        for (int i = 0; i < length; i++) {
//            Scanner s3 = new Scanner(System.in);
//            arr[i] = s3.nextInt();
//        }
//        System.out.println("please enter the element that want to delete:");
//        int target = scanner.nextInt();
//        Array array = new Array(length);
//        System.out.println(Arrays.toString(array.removeElement(arr, target)));
//    }
}
