package no.dervis.romannums;

public class RomanNums5 {

    final int[] arr = new int[] {900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    final String[] str = new String[] {"CM", "D", "CD", "C", "XC", "L", "XL", "X" ,"IX", "V", "IV", "I"};

    public String toRoman(int number) {
        StringBuilder romanText = new StringBuilder();

        while (number > 0) {
            int index = 0, c;
            while ((c = arr[index]) > number) index++;
            romanText.append(str[index]);
            number -= c;
        }

        return romanText.toString();
    }
}

/*
632
        632 / 700 = 0
        632 / 500 = 1
        632 % 600 = 132
        132 /100 = 1
        32/10 = 3
        DCxxxii
 */