package no.dervis.romannums;

import java.util.Map;

public class RomanNums2 {

    Map<Integer, Tuples<int[], String[]>> model = Map.of(
            1,  new Tuples<>(new int[]{9, 5, 4, 1}, new String[]{"IX", "V", "IV", "I"}),
            10, new Tuples<>(new int[]{90, 50, 40, 10}, new String[]{"XC", "L", "XL", "X"}),
            100, new Tuples<>(new int[]{900, 500, 400, 100}, new String[]{"CM", "D", "CD", "C"})
    );

    public String toRoman(int number) {
        return toRoman(new Tuples(number, ""));
    }

    /*
     * This solution uses the common logarithm
     * to find the base through the exponential function 10^x.
     */
    public String toRoman(Tuples<Integer, String> tuple) {
        if (tuple.left == 0) return tuple.right;

        int base = (int) Math.pow(10, (int) Math.log10(tuple.left));
        var map = model.get(base);

        for (int i = 0; i < map.left.length; i++) {
            while (tuple.left >= map.left[i]) {
                tuple.right += map.right[i];
                tuple.left -= map.left[i];
            }
        }

        return toRoman(tuple);
    }

    private static class Tuples<X, Y> {
        X left;
        Y right;

        public Tuples(X left, Y right) {
            this.left = left;
            this.right = right;
        }
    }

}
