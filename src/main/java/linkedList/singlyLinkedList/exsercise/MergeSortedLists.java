package linkedList.singlyLinkedList.exsercise;

public class MergeSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        // Attach the remaining part
        if (list1 != null) {
            tail.next = list1;
        } else {
            tail.next = list2;
        }

        return head.next;
    }

    public ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int n : arr) {
            current.next = new ListNode(n);
            current = current.next;
        }
        return dummy.next;
    }

    public void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        MergeSortedLists mergeSortedLists = new MergeSortedLists();
        mergeSortedLists.printList(mergeSortedLists.mergeTwoLists(mergeSortedLists.buildList(new int[]{1, 3, 4}), mergeSortedLists.buildList(new int[]{1, 2, 4})));
    }
}
