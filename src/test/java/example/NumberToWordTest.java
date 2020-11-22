package example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/11/16.
 */
public class NumberToWordTest {

    private static Stream<Arguments> provideArguments() {
        return Stream.of(
                Arguments.of("0", "zero"),
                Arguments.of("1", "one"),
                Arguments.of("2", "two"),
                Arguments.of("3", "three"),
                Arguments.of("4", "four"),
                Arguments.of("5", "five"),
                Arguments.of("6", "six"),
                Arguments.of("7", "seven"),
                Arguments.of("8", "eight"),
                Arguments.of("9", "nine"),

                Arguments.of("10", "ten"),
                Arguments.of("11", "eleven"),
                Arguments.of("12", "twelve"),
                Arguments.of("13", "thirteen"),
                Arguments.of("14", "fourteen"),
                Arguments.of("15", "fifteen"),
                Arguments.of("16", "sixteen"),
                Arguments.of("17", "seventeen"),
                Arguments.of("18", "eighteen"),
                Arguments.of("19", "nineteen"),

                Arguments.of("20", "twenty"),
                Arguments.of("21", "twenty one"),
                Arguments.of("22", "twenty two"),
                Arguments.of("23", "twenty three"),
                Arguments.of("28", "twenty eight"),
                Arguments.of("29", "twenty nine"),

                Arguments.of("30", "thirty"),
                Arguments.of("31", "thirty one"),
                Arguments.of("40", "forty"),
                Arguments.of("41", "forty one"),
                Arguments.of("50", "fifty"),
                Arguments.of("60", "sixty"),
                Arguments.of("70", "seventy"),
                Arguments.of("80", "eighty"),
                Arguments.of("90", "ninety"),

                Arguments.of("100", "one hundred"),
                Arguments.of("101", "one hundred one"),
                Arguments.of("115", "one hundred fifteen"),
                Arguments.of("121", "one hundred twenty one"),
                Arguments.of("151", "one hundred fifty one"),
                Arguments.of("419", "four hundred nineteen"),
                Arguments.of("951", "nine hundred fifty one"),

                Arguments.of("1000", "one thousand,"),
                Arguments.of("1001", "one thousand, one"),
                Arguments.of("1321", "one thousand, three hundred twenty one"),
                Arguments.of("1311", "one thousand, three hundred eleven"),
                Arguments.of("1501", "one thousand, five hundred one"),

                Arguments.of("10501", "ten thousand, five hundred one"),
                Arguments.of("15501", "fifteen thousand, five hundred one"),
                Arguments.of("100501", "one hundred thousand, five hundred one"),
                Arguments.of("101501", "one hundred one thousand, five hundred one"),
                Arguments.of("911501", "nine hundred eleven thousand, five hundred one"),

                Arguments.of("1000000", "one million,"),
                Arguments.of("1001501", "one million, one thousand, five hundred one"),
                Arguments.of("1201501", "one million, two hundred one thousand, five hundred one"),
                Arguments.of("1201711", "one million, two hundred one thousand, seven hundred eleven")
        );
    }

    @ParameterizedTest
    @MethodSource("provideArguments")
    public void assertEqual(int number, String expected) {
        assertThat(NumberToWord.convert(number)).isEqualTo(expected);
    }

}
