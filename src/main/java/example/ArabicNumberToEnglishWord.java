package example;

import org.apache.commons.lang3.StringUtils;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author huisheng.jin
 * @date 2020/11/16.
 */
public class ArabicNumberToEnglishWord {

    private static final int HUNDRED_NUMBER = 100;
    private static final int TWENTY_NUMBER = 20;
    private static final String HUNDRED_WORD = "hundred";
    private static final String ZERO_WORD = "zero";
    private static final int ONE_THOUSAND_NUMBER = 1000;

    public static String convert(int number) {
        if (WordContainer.contains(number)) {
            return WordContainer.get(number);
        }
        if (number > 1000000) {
            return WordContainer.get(number / 1000000) + " million, "
                    + convertBiggerThanOneThousandAndLessThanOneMillion(number / 1000)
                    + convertLessThanOneThousandNumber(number % 1000);
        }
        return convertBiggerThanOneThousandAndLessThanOneMillion(number)
                + convertLessThanOneThousandNumber(number % 1000);
    }

    private static String convertBiggerThanOneThousandAndLessThanOneMillion(int number) {
        String thousandNumberWord = convertLessThanOneThousandNumber(number / 1000);
        return !thousandNumberWord.equals(ZERO_WORD)
                ? thousandNumberWord + " thousand, "
                : "";
    }

    private static String convertLessThanOneThousandNumber(int number) {
        String hundredNumberWord = convertBiggerThanHundredNumber(number);
        String lessThanHundredWord = convertNumberLessThanOneHundred(number);
        if (StringUtils.isNotBlank(hundredNumberWord)
                && lessThanHundredWord.equals(ZERO_WORD)) {
            lessThanHundredWord = "";
        }
        return reduce(hundredNumberWord, lessThanHundredWord);
    }

    private static String convertBiggerThanHundredNumber(int number) {
        int hundredDigitNumber = number / HUNDRED_NUMBER;
        String hundredNumberWord = WordContainer.get(hundredDigitNumber);
        return !hundredNumberWord.equals(ZERO_WORD)
                ? hundredNumberWord + " " + HUNDRED_WORD
                : "";
    }

    private static String convertNumberLessThanOneHundred(int number) {
        number = number % HUNDRED_NUMBER;
        if (number >= TWENTY_NUMBER) {
            String hundredNumberWord = WordContainer.get(number - number % 10);
            String digitNumberWord = WordContainer.get(number % 10);
            return reduce(hundredNumberWord, digitNumberWord);
        } else {
            return reduce(WordContainer.get(number));
        }
    }

    private static String reduce(String... words) {
        return Stream.of(words)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.joining(" "));
    }

}
