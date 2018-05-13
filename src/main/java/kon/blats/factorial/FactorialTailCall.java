package kon.blats.factorial;

/**
 * Created by kon on 6/5/2018.
 */
public class FactorialTailCall {

    public static long calculate(long aNumber) {
        if (aNumber < 0) {
            throw new IllegalArgumentException("The number must >= to zero");
        }
        return calculateAcc(1, aNumber);
    }

    private static long calculateAcc(long acc, long aNumber) {
        if (aNumber == 0) {
            return acc;
        } else {
            return calculateAcc(acc * aNumber, --aNumber);
        }
    }
}
