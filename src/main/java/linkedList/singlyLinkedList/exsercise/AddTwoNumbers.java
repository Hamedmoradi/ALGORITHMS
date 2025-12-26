package linkedList.singlyLinkedList.exsercise;


public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1, l2, 0);
    }

    private ListNode add(ListNode l1, ListNode l2, int carry) {

        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int x = (l1 != null) ? l1.val : 0;
        int y = (l2 != null) ? l2.val : 0;

        int sum = x + y + carry;

        ListNode node = new ListNode(sum % 10);

        node.next = add((l1 != null) ? l1.next : null, (l2 != null) ? l2.next : null, sum / 10);

        return node;
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

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }


    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode l1 = addTwoNumbers.buildList(new int[]{9, 4, 3});
        ListNode l2 = addTwoNumbers.buildList(new int[]{5, 6, 4});
        printList(l1);
        printList(l2);
        printList(addTwoNumbers.addTwoNumbers(l1, l2));
    }
}
