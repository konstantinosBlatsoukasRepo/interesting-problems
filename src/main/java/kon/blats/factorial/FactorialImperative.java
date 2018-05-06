package kon.blats.factorial;

/**
 * Created by kon on 6/5/2018.
 */
public class FactorialImperative {

    public static long calculate(long aNumber) {
        if (aNumber < 0) {
            throw new IllegalArgumentException("The number must >= to zero");
        }

        if (aNumber == 0) {return 1;}

        long acc = 1;
        for (long counter = aNumber; counter > 0; counter--) {
            acc = acc * counter;
        }

        return acc;
    }
}
