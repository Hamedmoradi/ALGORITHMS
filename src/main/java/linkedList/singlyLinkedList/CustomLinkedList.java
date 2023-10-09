package linkedList.singlyLinkedList;

public class CustomLinkedList<T extends Comparable<T>> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public CustomLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void insertFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        if (isEmpty()) {
            tail = newNode;
        }
        size++;
    }

    public void insertLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insertInTheMiddle(T data, int position) {
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
            throw new IllegalArgumentException("Invalid position. Position must be between 0 and " + (size - 1) + ".");
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

            Node<T> nodeToRemove = current.next;

            removedData = nodeToRemove.data;

            current.next = nodeToRemove.next;

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
        Node<T> next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;
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
            return;
        }

        CustomLinkedList<T> leftHalf = new CustomLinkedList<>();
        CustomLinkedList<T> rightHalf = new CustomLinkedList<>();
        splitList(this, leftHalf, rightHalf);

        leftHalf.sortLinkedList();
        rightHalf.sortLinkedList();

        merge(leftHalf, rightHalf);
    }

    private void splitList(CustomLinkedList<T> source, CustomLinkedList<T> left, CustomLinkedList<T> right) {
        Node<T> current = source.head;
        int middle = source.size / 2;
        int i = 0;

        while (current != null) {
            if (i < middle) {
                left.insertLast(current.data);
            } else {
                right.insertLast(current.data);
            }
            current = current.next;
            i++;
        }
    }

    private void merge(CustomLinkedList<T> left, CustomLinkedList<T> right) {
        Node<T> leftCurrent = left.head;
        Node<T> rightCurrent = right.head;
        clear();

        while (leftCurrent != null && rightCurrent != null) {
            if (leftCurrent.data.compareTo(rightCurrent.data) <= 0) {
                insertLast(leftCurrent.data);
                leftCurrent = leftCurrent.next;
            } else {
                insertLast(rightCurrent.data);
                rightCurrent = rightCurrent.next;
            }
        }

        while (leftCurrent != null) {
            insertLast(leftCurrent.data);
            leftCurrent = leftCurrent.next;
        }

        while (rightCurrent != null) {
            insertLast(rightCurrent.data);
            rightCurrent = rightCurrent.next;
        }
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }


    //toArray()
//getNthFromTheEnd()--->20 min
//Check to see if a linked list has a loop. LinkedList.hasLoop()
//Find the middle of a linked list in one pass.
//Search an element in a Linked List (Recursive)
//Find Length of a Linked List (Iterative and Recursive)
    public static void main(String[] args) {
        CustomLinkedList<Integer> customList = new CustomLinkedList<>();
        customList.insertLast(3);
        customList.insertLast(1);
        customList.insertLast(4);
        customList.insertLast(8);
        customList.insertLast(4);
        customList.insertLast(2);
        customList.insertLast(6);

        int searchValue = 2;
        int newData = 7;
        int position = 2;
        int positionToRemove = 2;

        System.out.print("Original Linked List: ");
        customList.printList();

        customList.reverse();
        System.out.print("Reversed Linked List: ");
        customList.printList();

        customList.insertFirst(9);
        System.out.print("Insert at the First: ");
        customList.printList();

        customList.sortLinkedList();
        System.out.print("Sorted Linked List: ");
        customList.printList();

        if (customList.indexOf(searchValue) != -1) {
            System.out.println("Index of value " + searchValue + " : " + customList.indexOf(searchValue));
        } else {
            System.out.println("Value " + searchValue + " not found in the linked list.");
        }

        customList.insertInTheMiddle(newData, position);
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
