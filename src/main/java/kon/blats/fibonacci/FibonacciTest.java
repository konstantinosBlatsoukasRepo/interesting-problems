package kon.blats.fibonacci;

/**
 * Created by kon on 13/5/2018.
 */
public class FibonacciTest {
    public static void main(String[] args) {
        FibonacciDynamic fibonacciDynamic = new FibonacciDynamic(7);
        int result = fibonacciDynamic.calculate(7);
        System.out.println("result = " + result);
//        System.out.println(FibonacciImperative.calculate(30));
//        System.out.println(FibonacciRecursive.calculate(30));
//        System.out.println(FibonacciTailCall.calculate(30));
    }
}
