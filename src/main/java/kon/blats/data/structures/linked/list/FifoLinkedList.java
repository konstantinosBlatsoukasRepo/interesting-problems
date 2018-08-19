package kon.blats.data.structures.linked.list;

/**
 * Created by kon on 19/8/2018.
 */
public class FifoLinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node next;
    }

    private Node<T> startNode;
    private Node<T> lastNode;

    public void enqueue(T data) {
        Node<T> newNode = new Node<>();
        newNode.data = data;
        if (startNode == null) {
            startNode = newNode;
            return;
        }

        if (lastNode == null) {
           lastNode = newNode;
           startNode.next = lastNode;
        } else {
            lastNode.next = newNode;
            lastNode = newNode;
        }
    }

    public T dequeue() {
        if (startNode == null) {
            throw new IllegalArgumentException("There is nothing to dequeue");
        } else {
            T returnedData = startNode.data;
            startNode = startNode.next;
            return returnedData;
        }
    }

    public static void main(String[] args) {
        FifoLinkedList<String> fifoLinkedList = new FifoLinkedList<>();
        fifoLinkedList.enqueue("a");
        fifoLinkedList.enqueue("b");
        fifoLinkedList.enqueue("c");

        System.out.println(fifoLinkedList.dequeue());
        System.out.println(fifoLinkedList.dequeue());
        System.out.println(fifoLinkedList.dequeue());
        System.out.println(fifoLinkedList.dequeue());
    }
}
