package linkedList.singlyLinkedList.exsercise;

public class RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node
                current.next = current.next.next;
            } else {
                // Move to the next distinct element
                current = current.next;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int n : arr) {
            current.next = new ListNode(n);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 3, 4, 5, 6};

        System.out.println("Original List:");
        ListNode head = buildList(arr);
        printList(head);

        System.out.println("After removing duplication: ");
        ListNode newHead = deleteDuplicates(head);
        printList(newHead);
    }
}
