package linkedList.structure;

public class CustomLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addAtFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        if (isEmpty()) {
            tail = newNode;
        }
        size++;
    }

    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void addInTheMiddle(T data, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position.");
        }

        Node<T> newNode = new Node<>(data);

        if (position == 0) {
            newNode.next = head;
            head = newNode;
            if (isEmpty()) {
                tail = newNode;
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;

            if (position == size) {
                tail = newNode;
            }
        }

        size++;
    }

    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("The linked list is empty.");
        }
        T removedData = head.data;
        head = head.next;
        size--;
        if (isEmpty()) {
            tail = null;
        }
        return removedData;
    }

    public T removeFromLast() {
        if (isEmpty()) {
            throw new IllegalStateException("The linked list is empty.");
        }

        T removedData;

        if (head == tail) {
            removedData = head.data;
            head = null;
            tail = null;
        } else {
            Node<T> current = head;
            while (current.next != tail) {
                current = current.next;
            }

            removedData = tail.data;
            current.next = null;
            tail = current;
        }

        size--;
        return removedData;
    }

    public T removeFromMiddle(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Invalid position.");
        }

        T removedData;

        if (position == 0) {
            removedData = head.data;
            head = head.next;
            if (size == 1) {
                tail = null;
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            removedData = current.next.data;
            current.next = current.next.next;
            if (position == size - 1) {
                tail = current;
            }
        }

        size--;
        return removedData;
    }

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean containsValue(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public T valueOf(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index is out of bounds.");
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.data;
    }


    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
        // Update tail to point to the last element (head)
        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
    }

    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }

        return -1;
    }


    public void sortLinkedList() {
        if (size <= 1) {
            // Already sorted or empty list, nothing to do
            return;
        }

        // Split the list into two halves
        CustomLinkedList<T> leftHalf = new CustomLinkedList<>();
        CustomLinkedList<T> rightHalf = new CustomLinkedList<>();
        splitList(this, leftHalf, rightHalf);

        // Recursively sort the two halves
        leftHalf.sortLinkedList();
        rightHalf.sortLinkedList();

        // Merge the sorted halves back together
        merge(leftHalf, rightHalf);
    }

    // Helper method to split the list into two halves
    private void splitList(CustomLinkedList<T> source, CustomLinkedList<T> left, CustomLinkedList<T> right) {
        Node<T> current = source.head;
        int middle = source.size / 2;
        int i = 0;

        while (current != null) {
            if (i < middle) {
                left.addLast(current.data);
            } else {
                right.addLast(current.data);
            }
            current = current.next;
            i++;
        }
    }

    // Helper method to merge two sorted lists
    private void merge(CustomLinkedList<T> left, CustomLinkedList<T> right) {
        Node<T> leftCurrent = left.head;
        Node<T> rightCurrent = right.head;
        clear();

        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.data.compareTo(rightCurrent.data) <= 0) {
                addLast(leftCurrent.data);
                leftCurrent = leftCurrent.next;
            } else {
                addLast(rightCurrent.data);
                rightCurrent = rightCurrent.next;
            }
        }

        while (leftCurrent != null) {
            addLast(leftCurrent.data);
            leftCurrent = leftCurrent.next;
        }

        while (rightCurrent != null) {
            addLast(rightCurrent.data);
            rightCurrent = rightCurrent.next;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }
    // ... (other methods for linked list operations)


    //Search an element in a Linked List (Iterative and Recursive)
//Find Length of a Linked List (Iterative and Recursive)
    public static void main(String[] args) {
        CustomLinkedList<Integer> customList = new CustomLinkedList<>();
        customList.addLast(3);
        customList.addLast(1);
        customList.addLast(4);
        customList.addLast(8);
        customList.addLast(4);
        customList.addLast(2);
        customList.addLast(6);

        int searchValue = 2;
        int newData = 7;
        int position = 2;
        int positionToRemove = 2;

        System.out.print("Original Linked List: ");
        customList.printList();

        customList.reverse();
        System.out.print("Reversed Linked List: ");
        customList.printList();


        customList.sortLinkedList();
        System.out.print("Sorted Linked List: ");
        customList.printList();

        if (customList.indexOf(searchValue) != -1) {
            System.out.println("Index of value " + searchValue + " : " + customList.indexOf(searchValue));
        } else {
            System.out.println("Value " + searchValue + " not found in the linked list.");
        }

        customList.addInTheMiddle(newData, position);
        System.out.print("Linked List after adding in the middle: ");
        customList.printList();

        System.out.println("Contains value " + searchValue + ": " + customList.containsValue(searchValue));

        System.out.println("Removed Element at position " + positionToRemove + ": " + customList.removeFromMiddle(positionToRemove));
        System.out.print("Linked List after removing from the middle: ");
        customList.printList();

        System.out.println("Removed Element: " + customList.removeFirst());
        System.out.print("Linked List after removing from the First: ");
        customList.printList();

        System.out.println("Removed Element: " + customList.removeFromLast());
        System.out.print("Linked List after removing from the Last: ");
        customList.printList();

        int index = 4;
        System.out.println("Value Of  Index " + index + " : " + customList.valueOf(4));
        customList.printList();
    }
}
