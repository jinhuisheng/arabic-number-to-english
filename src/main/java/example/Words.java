package example;

import java.util.HashMap;

/**
 * @author huisheng.jin
 * @date 2020/11/19.
 */
public class Words {
    private static HashMap<Integer, String> map;

    static {
        map = new HashMap<>();
        map.put(0, "");
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
        map.put(100, "one hundred");
        map.put(1000, "one thousand,");
        map.put(1000000, "one million,");
    }


    public static boolean contains(int number) {
        return map.containsKey(number);
    }

    public static String get(int number) {
        return map.get(number);
    }
}
