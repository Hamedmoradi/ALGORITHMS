package linkedList.structure;

public class CustomLinkedList<T> {
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

    // Method to add an element at a specified position in the linked list
// Method to add an element at a specified position in the linked list
    public void addInTheMiddle(T data, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Invalid position.");
        }

        Node<T> newNode = new Node<>(data);

        if (position == 0) {
            // Insert at the beginning
            newNode.next = head;
            head = newNode;
            if (isEmpty()) {
                tail = newNode; // Update tail when adding the first element
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;

            if (position == size) {
                // Update tail when adding at the end
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

    public void printList() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public Boolean containsValue(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true; // Value found
            }
            current = current.next;
        }
        return false; // Value not found
    }

    public void reverse() {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;

        while (current != null) {
            next = current.next; // Save the next node
            current.next = prev; // Reverse the link

            // Move the pointers one step forward
            prev = current;
            current = next;
        }

        // Update the head to the last node, which is now the new head
        head = prev;
    }

    public int indexOf(T value) {
        Node<T> current = head;
        int index = 0;

        while (current != null) {
            if (current.data.equals(value)) {
                return index; // Value found, return its index
            }
            current = current.next;
            index++;
        }

        return -1; // Value not found, return -1
    }

    public static void main(String[] args) {
        CustomLinkedList<Integer> customList = new CustomLinkedList<>();

        customList.addLast(1);
        customList.addLast(2);
        customList.addLast(3);

        System.out.print("Original Linked List: ");
        customList.printList();

        customList.reverse();

        System.out.print("Reversed Linked List: ");
        customList.printList();
        int searchValue = 2;
        int index = customList.indexOf(searchValue);

        if (index != -1) {
            System.out.println("Index of value " + searchValue + ": " + index);
        } else {
            System.out.println("Value " + searchValue + " not found in the linked list.");
        }
        int newData = 4;
        int position = 2;

        customList.addInTheMiddle(newData, position);

        System.out.print("Linked List after adding in the middle: ");
        customList.printList();
        int removedElement = customList.removeFromLast();
        System.out.println("Removed Element: " + removedElement);

        boolean contains = customList.containsValue(searchValue);
        System.out.println("Contains value " + searchValue + ": " + contains);


    }
}

