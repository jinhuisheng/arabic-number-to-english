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
    private static final String ZERO_WORD = "zero";
    private static final String HUNDRED_WORD = "hundred";
    private static final String THOUSAND_WORD = "thousand,";
    private static final String MILLION_WORD = "million,";
    private static final int ZERO_NUMBER = 0;
    private static final int TWENTY_NUMBER = 20;
    private static final int HUNDRED_NUMBER = 100;
    private static final int THOUSAND_NUMBER = 1000;
    private static final int MILLION_NUMBER = 1000000;
    private final List<String> list;
    private final int number;

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
        addMillions(number / MILLION_NUMBER);
        addThousands((number - number / MILLION_NUMBER * MILLION_NUMBER) / THOUSAND_NUMBER);
        addHundreds(((number - number / MILLION_NUMBER * MILLION_NUMBER) % THOUSAND_NUMBER) / HUNDRED_NUMBER);
        addTenDigit(number % THOUSAND_NUMBER % HUNDRED_NUMBER);
        return reduce(list);
    }

    private void addMillions(int number) {
        list.add(millionNumbers(number));
    }

    private void addThousands(int number) {
        List<String> thousandWords = new ArrayList<>();
        thousandWords.add(hundredNumbers(number % THOUSAND_NUMBER / HUNDRED_NUMBER));
        thousandWords.add(tenDigitNumbers(number % THOUSAND_NUMBER % HUNDRED_NUMBER));
        if (thousandWords.stream().anyMatch(StringUtils::isNotBlank)) {
            thousandWords.add(THOUSAND_WORD);
        }
        list.addAll(thousandWords);
    }

    private void addHundreds(int hundreds) {
        list.add(hundredNumbers(hundreds));
    }

    private void addTenDigit(int number) {
        list.add(tenDigitNumbers(number));
    }

    private String millionNumbers(int millions) {
        return millions == ZERO_NUMBER ? "" : Words.get(millions) + " " + MILLION_WORD;
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
