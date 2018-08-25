package kon.blats.data.structures.queue;

/**
 * Created by k.blatsoukas on 8/14/2018.
 */
public class MyQueue<T> {

  private static class MyQueueNode<T> {
    private T data;
    private MyQueueNode<T> nextNode;

    public MyQueueNode(T data) {
      this.data = data;
    }
  }

  private MyQueueNode<T> firstNode;
  private MyQueueNode<T> lastNode;

  public void add(T data) {
    MyQueueNode<T> newNode = new MyQueueNode<T>(data);

    if (lastNode != null) {
      lastNode.nextNode = newNode;
    }
    lastNode = newNode;

    if (firstNode == null) {
      firstNode = lastNode;
    }
  }

  public T remove() {
    if (firstNode == null) {
      throw new IllegalArgumentException();
    }
    T data = firstNode.data;
    firstNode = firstNode.nextNode;
    if (firstNode == null) {
      lastNode = firstNode;
    }
    return data;
  }

  public void printQueue() {
    printQueueHelper(firstNode);
  }

  public void printQueueHelper(MyQueueNode<T> firstNode) {
    if (firstNode != null) {
      System.out.println(firstNode.data);
      printQueueHelper(firstNode.nextNode);
    }
    return;
  }


}
