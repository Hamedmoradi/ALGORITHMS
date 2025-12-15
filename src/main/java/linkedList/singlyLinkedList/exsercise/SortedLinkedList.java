package linkedList.singlyLinkedList.exsercise;

public class SortedLinkedList {
    public static ListNode sortList(ListNode head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // 1. Split the list
        ListNode mid = findMiddle(head);
        ListNode rightHead = mid.next;
        mid.next = null;

        // 2. Sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        // 3. Merge sorted halves
        return merge(left, right);
    }

    // Find middle using slow & fast pointers
    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted lists
    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // Attach remaining nodes
        current.next = (l1 != null) ? l1 : l2;

        return dummy.next;
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

        int[] arr = {4, 2, 1, 3};

        System.out.println("Original List:");
        ListNode head = buildList(arr);
        printList(head);

        System.out.println("After sorting value: ");
        ListNode newHead = sortList(head);
        printList(newHead);
    }
}
