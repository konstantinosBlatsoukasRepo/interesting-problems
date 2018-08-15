package kon.blats.fibonacci;

/**
 * Created by kon on 15/8/2018.
 */
public class FibonacciDynamic {

    private int[] comptutedNumbers;

    public FibonacciDynamic(int number) {
        comptutedNumbers = new int[number + 1];
        comptutedNumbers[0] = 0;
        comptutedNumbers[1] = 1;
    }

    public int calculate(int number) {
        if (number == 0 || number == 1 || isAlreadyComputed(number)) {
            return comptutedNumbers[number];
        } else {
            comptutedNumbers[number] = calculate(number - 1) + calculate(number - 2);
            return comptutedNumbers[number];
        }
    }

    private boolean isAlreadyComputed(int number) {
        return number != 0 && comptutedNumbers[number] != 0;
    }
}
