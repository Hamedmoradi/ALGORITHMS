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

        if (index + 1 > items.length) {
            int[] newArr = new int[index + 1];
            for (int i = 0; i < newArr.length; i++) {
                if (i == index) {
                    newArr[i] = value;
                } else {
                    newArr[i] = items[i];
                }
            }
            return newArr;
        } else {
            items[index] = value;
            return items;
        }
    }

    public void printArray() {
        for (int a : items) {
            System.out.println(a);
        }
    }


}
