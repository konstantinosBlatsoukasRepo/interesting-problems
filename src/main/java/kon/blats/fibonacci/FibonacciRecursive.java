package kon.blats.fibonacci;

/**
 * Created by kon on 13/5/2018.
 */
public class FibonacciRecursive {

    public static long calculate(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("input must be greater or equals to zero");
        }

        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else {
           return  calculate(number - 1) + calculate(number - 2);
        }
    }
}
