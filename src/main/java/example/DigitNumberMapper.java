package example;

/**
 * @author huisheng.jin
 * @date 2020/11/16.
 */
public class DigitNumberMapper {
    private Integer number;
    private String digit;
    private String word;

    public DigitNumberMapper(Integer number, String digit, String word) {

        this.number = number;
        this.digit = digit;
        this.word = word;
    }

    public Integer getNumber() {
        return number;
    }

    public String getDigit() {
        return digit;
    }

    @Override
    public String toString() {
        return word;
    }
}
