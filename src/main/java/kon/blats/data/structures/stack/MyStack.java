package kon.blats.data.structures.stack;

/**
 * Created by k.blatsoukas on 8/14/2018.
 */
public class MyStack<T> {

  private static class StackNode<T> {
    private T data;
    private StackNode<T> nextNode;

    public StackNode(T data) {
      this.data = data;
    }
  }

  private StackNode<T> top;

  public void push(T data) {
    StackNode<T> newTopNode = new StackNode<T>(data);
    newTopNode.nextNode = top;
    top = newTopNode;
  }

  public T pop() {
    if (top == null) {
      throw new IllegalStateException();
    }

    T data = top.data;
    top = top.nextNode;
    return data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  public void printStack() {
    printStackHelper(top);
  }

  public void printStackHelper(StackNode<T> top) {
    if (top != null) {
      System.out.println(top.data);
      printStackHelper(top.nextNode);
    }
    return;
  }
}
