package kon.blats.factorial;

/**
 * Created by kon on 6/5/2018.
 */
public class FactorialRecursive {

    public static long calculate(long aNumber) {
        if (aNumber < 0) {
            throw new IllegalArgumentException("The number must >= to zero");
        }
        if (aNumber == 0){
            return 1;
        } else {
            return aNumber * calculate(aNumber - 1);
        }
    }
}
