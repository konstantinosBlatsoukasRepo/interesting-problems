package kon.blats.data.structures.linked.list;

import java.util.LinkedList;

/**
 * Created by kon on 2/9/2018.
 */
public class ListPartitioner {
    private ListNode head;

    public ListPartitioner(ListNode head) {
        this.head = head;
    }

    public ListNode partition(ListNode givenHead, int k) {
        ListNode newHead = new ListNode();
        ListNode newTail = newHead;
        ListNode currentNode = givenHead;
        while (currentNode != null) {
            ListNode newNode = new ListNode();
            newNode.data = currentNode.data;
            if (currentNode.data > k) {
                newTail.next = newNode;
                newTail = newNode;
            } else {
                newNode.next = newHead;
                newHead = newNode;
            }
            currentNode = currentNode.next;
        }
        return newHead;
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
        head.data = 34;
        ListNode sec = new ListNode();
        head.next = sec;
        sec.data = 4;
        ListNode third = new ListNode();
        third.data = 52;
        sec.next = third;
        ListNode forth = new ListNode();
        forth.data = 3;
        third.next = forth;

        ListPartitioner partitioner = new ListPartitioner(head);
        partitioner.printList(partitioner.partition(head, 5));
    }
}
