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
    public String toRoman(int number, String ret) {

        int base = (int) Math.pow(10, (int) Math.log10(number));

        if (number == 0) return ret;

        if (base == 1) {
            Tuple t = calc(number, onesArr, onesStrArr, ret);
            return toRoman(t.rest, t.ret);
        }

        if (base == 10) {
            Tuple t2 = calc(number, tensArr, tenStrArr, ret);
            return toRoman(t2.rest, t2.ret);
        }

        if (base == 100) {
            Tuple t3 = calc(number,
                    hundredsArr, hundredsStrArr, ret);
            return toRoman(t3.rest, t3.ret);
        }


        return ret;
    }

    /*
     * The pattern below continues.
     */

    public Tuple calc(int n, int[] a, String[] b, String ret) {
        int rest = n;

        if (rest >= a[0]) {
            ret += b[0];
            rest -= a[0];
        }

        if (rest >= a[1]) {
            ret += b[1];
            rest -= a[1];
        }

        if (rest >= a[2]) {
            ret += b[2];
            rest -= a[2];
        }

        while (rest >= a[3]) {
            ret += b[3];
            rest -= a[3];
        }

        return new Tuple(ret, rest);
    }

    class Tuple {
        String ret;
        int rest;

        public Tuple(String ret, int rest) {
            this.ret = ret;
            this.rest = rest;
        }
    }
}
