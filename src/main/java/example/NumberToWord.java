package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author huisheng.jin
 * @date 2020/11/24.
 */
public class NumberToWord {

    public static final int TWENTY_NUMBER = 20;
    public static final int TEN_NUMBER = 10;
    private static HashMap<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(0, "zero");
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.put(4, "four");
        map.put(5, "five");
        map.put(6, "six");
        map.put(7, "seven");
        map.put(8, "eight");
        map.put(9, "nine");
        map.put(10, "ten");
        map.put(11, "eleven");
        map.put(12, "twelve");
        map.put(13, "thirteen");
        map.put(14, "fourteen");
        map.put(15, "fifteen");
        map.put(16, "sixteen");
        map.put(17, "seventeen");
        map.put(18, "eighteen");
        map.put(19, "nineteen");
        map.put(20, "twenty");
        map.put(30, "thirty");
        map.put(40, "forty");
        map.put(50, "fifty");
        map.put(60, "sixty");
        map.put(70, "seventy");
        map.put(80, "eighty");
        map.put(90, "ninety");
    }

    private final int number;
    private ArrayList<String> list;

    private NumberToWord(int number) {
        this.list = new ArrayList<>();
        this.number = number;
    }

    public static String convert(int number) {
        if (number == 0) {
            return "zero";
        }
        NumberToWord numberToWord = new NumberToWord(number);
        return numberToWord.convert();
    }

    private String convert() {
        int millionNumbers = number / 1000000;
        int thousandNumber = number % 1000000 / 1000;
        int hundredNumber = number % 1000 / 100;
        int tenDigitNumber = number % 100;
        addMillionNumberWord(millionNumbers);
        addThousandNumberWord(thousandNumber);
        addHundredNumberWord(hundredNumber);
        addTenDigitNumberWord(tenDigitNumber);
        return reduce();
    }

    private void addMillionNumberWord(int number) {
        if (number > 0) {
            addThousandNumberWord(number / 1000);
            list.add("one million,");
        }
    }

    private void addThousandNumberWord(int number) {
        if (number > 0) {
            addHundredNumberWord(number / 100);
            addTenDigitNumberWord(number % 100);
            list.add("thousand,");
        }
    }

    private void addHundredNumberWord(int number) {
        if (number > 0) {
            list.add(convertHundredDigitWord(number));
        }
    }

    private void addTenDigitNumberWord(int number) {
        if (number > 0) {
            list.add(convertLessThanHundredNumber(number));
        }
    }

    private String convertHundredDigitWord(int number) {
        return map.get(number) + " hundred";
    }

    private String convertLessThanHundredNumber(int number) {
        if (number < TWENTY_NUMBER) {
            return map.get(number);
        }
        int digitNumber = number % TEN_NUMBER;
        int tenDigitNumber = number - number % TEN_NUMBER;
        String tenDigitNumberWord = map.get(tenDigitNumber);
        String digitNumberWord = map.get(digitNumber);
        return digitNumber == 0
                ? tenDigitNumberWord
                : String.join(" ", tenDigitNumberWord, digitNumberWord);
    }

    private String reduce() {
        return list.stream().collect(Collectors.joining(" "));
    }

}
