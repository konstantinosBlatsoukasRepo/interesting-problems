package kon.blats.data.structures.linked.list;

/**
 * Created by kon on 2/9/2018.
 */
public class KthToTheLast {

    private int k;
    private ListNode head;

    public KthToTheLast(int k, ListNode head) {
        this.k = k;
        this.head = head;
    }

    public void printKthToLast() {
        ListNode kthNode = getKthNode(k, head);
        printList(kthNode);
    }

    private ListNode getKthNode(int k, ListNode head) {
        if (k == 1) {
            return head;
        }
        return getKthNode(--k, head.next);
    }

    private void printList(ListNode head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        printList(head.next);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.data = 3;
        ListNode sec = new ListNode();
        head.next = sec;
        sec.data = 4;
        ListNode third = new ListNode();
        third.data = 5;
        sec.next = third;
        ListNode forth = new ListNode();
        forth.data = 3;
        third.next = forth;
        KthToTheLast kthToTheLast = new KthToTheLast(2, head);
        kthToTheLast.printKthToLast();
    }
}
