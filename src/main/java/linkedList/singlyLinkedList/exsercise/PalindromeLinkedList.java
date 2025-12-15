package linkedList.singlyLinkedList.exsercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        List<Integer> asd = new ArrayList<>();
        while (head != null) {
            asd.add(head.val);
            head = head.next;
        }
        int s = asd.size() - 1;
        for (int i = 0; i < s; i++) {
            if (!Objects.equals(asd.get(i), asd.get(s - i))) {
                return false;
            }
        }
        return true;
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

        int[] arr = {4, 2};

        System.out.println("Original List:");
        ListNode head = buildList(arr);
        printList(head);

        System.out.println("Is Palindrome: ");
        boolean b = isPalindrome(head);
        System.out.println(b);
    }
}
