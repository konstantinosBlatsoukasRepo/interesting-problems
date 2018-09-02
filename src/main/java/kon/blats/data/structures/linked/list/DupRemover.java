package kon.blats.data.structures.linked.list;

import java.util.List;

/**
 * Created by kon on 2/9/2018.
 */
public class DupRemover {
    private ListNode listNode;

    public DupRemover(ListNode listNode) {
        this.listNode = listNode;
    }

    public void removeDups() {
        ListNode currentNode = listNode;
        while (currentNode != null) {
            ListNode runner = currentNode;
            while (runner.next != null) {
                if (runner.next.data == currentNode.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            currentNode = currentNode.next;
        }
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

        DupRemover remover = new DupRemover(head);
        remover.removeDups();
        System.out.println();
    }
}