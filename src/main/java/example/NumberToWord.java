package example;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huisheng.jin
 * @date 2020/11/16.
 */
public class NumberToWord {
    private static final String HUNDRED_WORD = "hundred";
    private static final String ZERO_WORD = "zero";
    private static final int TWENTY_NUMBER = 20;
    private static final int ZERO_NUMBER = 0;
    private static final String THOUSAND_WORD = "thousand,";
    private final List<String> list;
    private final int number;
    private final NumberCalculator numberCalculator = new NumberCalculator();

    private NumberToWord(int number) {
        this.list = new ArrayList<>();
        this.number = number;
    }

    public static String convert(int number) {
        if (number == 0) {
            return NumberToWord.ZERO_WORD;
        }
        return new NumberToWord(number).convert();
    }

    private String convert() {
        addThousands(numberCalculator.getThousands(number));
        addHundreds(numberCalculator.getHundreds(number));
        addTenDigit(numberCalculator.getTenDigit(number));
        return reduce(list);
    }

    private void addThousands(int number) {
        list.add(hundredNumbers(numberCalculator.getHundreds(number)));
        list.add(tenDigitNumbers(numberCalculator.getTenDigit(number)));
        if (list.stream().anyMatch(StringUtils::isNotBlank)) {
            list.add(THOUSAND_WORD);
        }
    }

    private void addHundreds(int hundreds) {
        list.add(hundredNumbers(hundreds));
    }

    private void addTenDigit(int number) {
        list.add(tenDigitNumbers(number));
    }

    private String hundredNumbers(int hundreds) {
        return hundreds == ZERO_NUMBER ? "" : Words.get(hundreds) + " " + HUNDRED_WORD;
    }

    private String tenDigitNumbers(int number) {
        if (number <= TWENTY_NUMBER) {
            return Words.get(number);
        } else {
            String tenDigitWord = Words.get(number - number % 10);
            String digitNumberWord = Words.get(number % 10);
            return reduce(Arrays.asList(tenDigitWord, digitNumberWord));
        }
    }

    private String reduce(List<String> list) {
        return list.stream()
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.joining(" "));
    }

}
