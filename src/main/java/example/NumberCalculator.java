package example;

/**
 * @author huisheng.jin
 */
public class NumberCalculator {
    private static final int HUNDRED_NUMBER = 100;
    private static final int THOUSAND_NUMBER = 1000;

    NumberCalculator() {
    }

    int getTenDigit(int number) {
        return number % THOUSAND_NUMBER % HUNDRED_NUMBER;
    }

    int getHundreds(int number) {
        return number % THOUSAND_NUMBER / HUNDRED_NUMBER;
    }

    int getThousands(int number) {
        return number / THOUSAND_NUMBER;
    }

    int getDigitNumber(int number) {
        return number % 10;
    }

    int getTenDigitNumber(int number) {
        return number - getDigitNumber(number);
    }
}