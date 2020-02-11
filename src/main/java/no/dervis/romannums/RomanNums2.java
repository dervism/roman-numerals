package no.dervis.romannums;

public class RomanNums2 {

    int[] onesArr = new int[] {9, 5, 4, 1};
    String[] onesStrArr = new String[] {"IX", "V", "IV", "I"};

    int[] tensArr = new int[] {90, 50, 40, 10};
    String[] tenStrArr = new String[] {"XC", "L", "XL", "X"};

    int[] hundredsArr = new int[] {900, 500, 400, 100};
    String[] hundredsStrArr = new String[] {"CM", "D", "CD", "C"};

    public String toRoman(int number) {
        return toRoman(new Tuple(number, ""));
    }

    /*
     * This solution uses the common logarithm
     * to find the base through the exponential function 10^x.
     */
    public String toRoman(Tuple tuple) {
        int number = tuple.number;
        String romanText = tuple.romanText;

        if (number == 0) return romanText;

        int base = (int) Math.pow(10, (int) Math.log10(number));

        return switch (base) {
            case 1 -> toRoman(calc(number, onesArr, onesStrArr, romanText));
            case 10 -> toRoman(calc(number, tensArr, tenStrArr, romanText));
            case 100 -> toRoman(calc(number, hundredsArr, hundredsStrArr, romanText));
            default -> romanText;
        };
    }

    /*
     * The pattern below continues.
     */

    public Tuple calc(int number, int[] numberArr, String[] romanStrArr, String romanText) {

        for (int i = 0; i < numberArr.length; i++) {
            while (number >= numberArr[i]) {
                romanText += romanStrArr[i];
                number -= numberArr[i];
            }
        }

        return new Tuple(number, romanText);
    }

    private static class Tuple {
        String romanText;
        int number;

        public Tuple(int number, String romanText) {
            this.romanText = romanText;
            this.number = number;
        }
    }
}
