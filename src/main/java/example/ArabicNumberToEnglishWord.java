package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author huisheng.jin
 * @date 2020/11/16.
 */
public class ArabicNumberToEnglishWord {

    private static HashMap<Integer, String> map;
    private static List<DigitNumberMapper> digitNumberMappers;

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

    static {
        digitNumberMappers = new ArrayList<>();
        digitNumberMappers.add(new DigitNumberMapper(2, "biggerThanOrEqualTwentyAndLessThanOneHundred", "twenty"));
        digitNumberMappers.add(new DigitNumberMapper(3, "biggerThanOrEqualTwentyAndLessThanOneHundred", "thirty"));
        digitNumberMappers.add(new DigitNumberMapper(4, "biggerThanOrEqualTwentyAndLessThanOneHundred", "forty"));
        digitNumberMappers.add(new DigitNumberMapper(5, "biggerThanOrEqualTwentyAndLessThanOneHundred", "fifty"));
        digitNumberMappers.add(new DigitNumberMapper(6, "biggerThanOrEqualTwentyAndLessThanOneHundred", "sixty"));
        digitNumberMappers.add(new DigitNumberMapper(7, "biggerThanOrEqualTwentyAndLessThanOneHundred", "seventy"));
        digitNumberMappers.add(new DigitNumberMapper(8, "biggerThanOrEqualTwentyAndLessThanOneHundred", "eighty"));
        digitNumberMappers.add(new DigitNumberMapper(9, "biggerThanOrEqualTwentyAndLessThanOneHundred", "ninety"));
    }

    public static String convert(int number) {
        if (map.containsKey(number)) {
            return map.get(number);
        }
        if (number >= 100) {
            String[] digitNumbers = String.valueOf(number).split("");

            String hundredNumber = "one";
            String hundredWord = "hundred";
            return hundredNumber + " " + hundredWord;
        }
        String[] digitNumbers = String.valueOf(number).split("");
        return getTenDigitWord(Integer.valueOf(digitNumbers[0]), "biggerThanOrEqualTwentyAndLessThanOneHundred")
                + " "
                + getDigitWord(Integer.valueOf(digitNumbers[1]));
    }

    private static String getDigitWord(Integer number) {
        return map.get(number);
    }

    private static String getTenDigitWord(Integer number, String unit) {
        return digitNumberMappers.stream()
                .filter(item -> item.getNumber().equals(number)
                        && item.getDigit().equals("biggerThanOrEqualTwentyAndLessThanOneHundred")
                )
                .findFirst()
                .get()
                .toString();
    }
}
