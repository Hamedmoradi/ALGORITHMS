package linkedList.singlyLinkedList.exsercise;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next;
        ListNode tail;
        ListNode current = head;

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
        return head;
    }

//    public ListNode reverseList(ListNode head) {
//        Stack<Integer> st = new Stack<>();
//        ListNode temp = head;
//        while(temp!=null){
//            st.push(temp.val);
//            temp=temp.next;
//        }
//        temp=head;
//        while(temp!=null){
//            temp.val=st.pop();
//            temp=temp.next;
//        }
//        return head;
//    }


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
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        int[] arr = {1, 2, 3, 4, 5, 6};
        ListNode head = buildList(arr);
        printList(reverseLinkedList.reverseList(head));
    }
}
