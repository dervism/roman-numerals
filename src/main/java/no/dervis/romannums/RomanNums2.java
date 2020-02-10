package no.dervis.romannums;

public class RomanNums2 {

    public String toRoman(int number) {
        return toRoman(number, new StringBuilder());
    }

    /*
     * This solution uses the common logarithm
     * to find the base through the exponential function 10^x.
     */
    public String toRoman(int number, StringBuilder ret) {

        int base = (int) Math.pow(10, (int) Math.log10(number));

        if (number == 0) return ret.toString();

        if (base == 1) toRoman(calc(number, ret,
                new int[] {9, 5, 4, 1},
                new String[] {"IX", "V", "IV", "I"}), ret);

        if (base == 10) toRoman(calc(number, ret,
                new int[] {90, 50, 40, 10},
                new String[] {"XC", "L", "XL", "X"}), ret);

        if (base == 100) toRoman(calc(number, ret,
                new int[] {900, 500, 400, 100},
                new String[] {"CM", "D", "CD", "C"}), ret);

        return ret.toString();
    }

    /*
     * The pattern below continues.
     */

    public int calc(int n, StringBuilder ret, int[] a, String[] b) {
        int rest = n;

        if (rest >= a[0]) {
            ret.append(b[0]);
            rest -= a[0];
        }

        if (rest >= a[1]) {
            ret.append(b[1]);
            rest -= a[1];
        }

        if (rest >= a[2]) {
            ret.append(b[2]);
            rest -= a[2];
        }

        while (rest >= a[3]) {
            ret.append(b[3]);
            rest -= a[3];
        }

        return rest;
    }
}
