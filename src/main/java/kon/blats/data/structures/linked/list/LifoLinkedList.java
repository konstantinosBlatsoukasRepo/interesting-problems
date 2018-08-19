package kon.blats.data.structures.linked.list;

/**
 * Created by kon on 19/8/2018.
 */
public class LifoLinkedList<T> {

    private static class Node<T> {
        private T data;
        private Node next;
    }

    private Node<T> startNode;

    public void add(T data) {
        if (startNode == null) {
            startNode = new Node<>();
            startNode.data = data;
        } else {
            Node<T> newNode = new Node<>();
            newNode.data = data;
            newNode.next = startNode;
            startNode = newNode;
        }
    }

    public T remove() {
        if (startNode == null) {
            throw new IllegalArgumentException("There is no Node to return");
        }

        T returnedValue = startNode.data;
        startNode = startNode.next;
        return returnedValue;
    }

    public static void main(String[] args) {
        LifoLinkedList<String> lifoLinkedList = new LifoLinkedList<>();
        lifoLinkedList.add("a");
        lifoLinkedList.add("b");

        System.out.println(lifoLinkedList.remove());
        System.out.println("just for fun");
    }
}
