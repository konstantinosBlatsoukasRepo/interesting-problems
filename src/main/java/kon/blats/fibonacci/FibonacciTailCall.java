package kon.blats.fibonacci;

/**
 * Created by kon on 13/5/2018.
 */
public class FibonacciTailCall {
    public static long calculate(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("input must be greater or equals to zero");
        }

        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        return accumulators(0, 1, number);
    }

    public static long accumulators(long firstAcc, long secondAcc, long number) {
        if (number == 1) {
            return secondAcc;
        } else {
            return accumulators(secondAcc, firstAcc + secondAcc, --number);
        }
    }

}
