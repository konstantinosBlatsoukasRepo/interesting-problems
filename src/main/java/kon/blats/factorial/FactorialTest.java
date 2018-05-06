package kon.blats.factorial;

/**
 * Created by kon on 6/5/2018.
 */
public class FactorialTest {
    public static void main(String[] args) {
        System.out.println(FactorialRecursive.calculate(23));
        System.out.println(FactorialTailCall.calculate(23));
        System.out.println(FactorialImperative.calculate(23));
    }
}
