package kon.blats.data.structures.queue;

/**
 * Created by k.blatsoukas on 8/14/2018.
 */
public class MyQueueTest {

  public static void main(String[] args) {
    MyQueue<String> myQueue = new MyQueue<>();
    myQueue.add("a");
    myQueue.add("b");
    myQueue.add("c");

    myQueue.remove();

    myQueue.printQueue();
  }
}
