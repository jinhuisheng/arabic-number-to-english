package example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * @author huisheng.jin
 * @date 2020/11/16.
 */
public class ArabicNumberToEnglishWordTest {

    @ParameterizedTest
    @CsvSource({
            "0,zero",
            "1,one",
            "2,two",
            "3,three",
            "4,four",
            "5,five",
            "6,six",
            "7,seven",
            "8,eight",
            "9,nine",
            "10,ten",

            "11,eleven",
            "12,twelve",
            "13,thirteen",
            "14,fourteen",
            "15,fifteen",
            "16,sixteen",
            "17,seventeen",
            "18,eighteen",
            "19,nineteen",
            "20,twenty",

            "21,twenty one",
            "22,twenty two",
            "23,twenty three",
            "28,twenty eight",
            "29,twenty nine",

            "30,thirty",
            "31,thirty one",
            "40,forty",
            "41,forty one",
            "50,fifty",
            "60,sixty",
            "70,seventy",
            "80,eighty",
            "90,ninety",

            "100,one hundred",
//            "101,one hundred one"

    })
    public void assertEqual(int number, String expected) {
        assertThat(ArabicNumberToEnglishWord.convert(number)).isEqualTo(expected);
    }


}
