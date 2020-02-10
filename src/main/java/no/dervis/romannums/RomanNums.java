package no.dervis.romannums;

public class RomanNums {

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

        if (base == 1) toRoman(ones(number, ret), ret);
        if (base == 10) toRoman(tens(number, ret), ret);
        if (base == 100) toRoman(hundreds(number, ret), ret);
        /*if (base == 1_000) toRoman(thoundsands(number, ret), ret);
        if (base == 10_000) toRoman(tenthousands(number, ret), ret);
        if (base == 100_000) toRoman(hundreds_thoundsands(number, ret), ret);
        if (base == 1_000_000) toRoman(millions(number, ret), ret);
        if (base == 10_000_000) toRoman(millions(number, ret), ret);
        if (base == 100_000_000) toRoman(millions(number, ret), ret);
        if (base == 1_000_000_000) toRoman(millions(number, ret), ret);*/

        return ret.toString();
    }

    /*
     * The pattern below continues.
     */

    public int hundreds(int n, StringBuilder ret) {
        int rest = n;

        if (rest >= 900) {
            ret.append("CM");
            rest -= 900;
        }

        if (rest >= 500) {
            ret.append("D");
            rest -= 500;
        }

        if (rest >= 400) {
            ret.append("CD");
            rest -= 400;
        }

        while (rest >= 100) {
            ret.append("C");
            rest -= 100;
        }

        return rest;
    }

    public int tens(int n, StringBuilder ret) {
        int rest = n;

        if (rest >= 90) {
            ret.append("XC");
            rest -= 90;
        }

        if (rest >= 50) {
            ret.append("L");
            rest -= 50;
        }

        if (rest >= 40) {
            ret.append("XL");
            rest -= 40;
        }

        while (rest >= 10) {
            ret.append("X");
            rest -= 10;
        }

        return rest;
    }

    public int ones(int n, StringBuilder ret) {
        int rest = n;

        if (rest >= 9) {
            ret.append("IX");
            rest -= 9;
        }

        if (rest >= 5) {
            ret.append("V");
            rest -= 5;
        }

        if (rest >= 4) {
            ret.append("IV");
            rest -= 4;
        }

        while (rest >= 1) {
            ret.append("I");
            rest--;
        }

        return rest;
    }

}
