package kon.blats.data.structures.stack;

/**
 * Created by k.blatsoukas on 8/14/2018.
 */
public class MyStackTest {
  public static void main(String[] args) {
    MyStack<String> myStack = new MyStack<>();
    myStack.push("a");
    myStack.push("b");

    myStack.printStack();
  }
}
