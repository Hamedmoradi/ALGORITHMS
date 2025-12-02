package linkedList.singlyLinkedList.exsercise;

public class RemoveLinklistElements {
    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode current = dummy;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return dummy.next;
    }
    /*
Why use a dummy node?

Because if the head itself needs to be removed, it makes it easy:

Example: head = [6,6,1,2], val = 6
Without a dummy, you need special handling.
With a dummy, everything is uniform.
    */


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

        int[] arr = {1, 2, 6, 3, 4, 5, 6};
        int val = 6;

        System.out.println("Original List:");
        ListNode head = buildList(arr);
        printList(head);

        System.out.println("After removing value: " + val);
        ListNode newHead = removeElements(head, val);
        printList(newHead);
    }
}
