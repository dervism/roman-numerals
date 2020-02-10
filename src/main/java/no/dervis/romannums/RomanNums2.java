package no.dervis.romannums;

public class RomanNums2 {

    int[] onesArr = new int[] {9, 5, 4, 1};
    String[] onesStrArr = new String[] {"IX", "V", "IV", "I"};

    int[] tensArr = new int[] {90, 50, 40, 10};
    String[] tenStrArr = new String[] {"XC", "L", "XL", "X"};

    int[] hundredsArr = new int[] {900, 500, 400, 100};
    String[] hundredsStrArr = new String[] {"CM", "D", "CD", "C"};

    public String toRoman(int number) {
        return toRoman(number, "");
    }

    /*
     * This solution uses the common logarithm
     * to find the base through the exponential function 10^x.
     */
    public String toRoman(int number, String romanText) {

        int base = (int) Math.pow(10, (int) Math.log10(number));

        if (number == 0) return romanText;

        if (base == 1) {
            Tuple t = calc(number, onesArr, onesStrArr, romanText);
            return toRoman(t.rest, t.romanText);
        }

        if (base == 10) {
            Tuple t = calc(number, tensArr, tenStrArr, romanText);
            return toRoman(t.rest, t.romanText);
        }

        if (base == 100) {
            Tuple t = calc(number, hundredsArr, hundredsStrArr, romanText);
            return toRoman(t.rest, t.romanText);
        }

        return romanText;
    }

    /*
     * The pattern below continues.
     */

    public Tuple calc(int number, int[] a, String[] b, String romanText) {

        if (number >= a[0]) {
            romanText += b[0];
            number -= a[0];
        }

        if (number >= a[1]) {
            romanText += b[1];
            number -= a[1];
        }

        if (number >= a[2]) {
            romanText += b[2];
            number -= a[2];
        }

        while (number >= a[3]) {
            romanText += b[3];
            number -= a[3];
        }

        return new Tuple(romanText, number);
    }

    private static class Tuple {
        String romanText;
        int rest;

        public Tuple(String romanText, int rest) {
            this.romanText = romanText;
            this.rest = rest;
        }
    }
}
