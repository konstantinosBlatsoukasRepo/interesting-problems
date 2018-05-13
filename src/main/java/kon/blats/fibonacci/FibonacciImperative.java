package kon.blats.fibonacci;

/**
 * Created by kon on 13/5/2018.
 */
public class FibonacciImperative {

    public static long calculate(long number) {
        if (number < 0) {
            throw new IllegalArgumentException("input must be greater or equals to zero");
        }

        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        long firstAcc = 0;
        long secondAcc = 1;
        long temp;
        while (number != 1) {
            temp = firstAcc;
            firstAcc  = secondAcc;
            secondAcc = temp + secondAcc;
            number--;
        }

        return secondAcc;
    }
}
