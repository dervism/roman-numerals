package no.dervis.romannums;

public class RomanNums3 {

    final String[][] arr = new String[][]{new String[] {"900", "500", "400", "100", "90", "50", "40", "10", "9", "5", "4", "1"},
            new String[] {"CM", "D", "CD", "C", "XC", "L", "XL", "X" ,"IX", "V", "IV", "I"}};

    public String toRoman(int number) {
        StringBuilder romanText = new StringBuilder();

        while (number > 0) {
            int index = 0, c = 0;
            while ((c = Integer.parseInt(arr[0][index])) > number) index++;
            while(number >= c) {
                romanText.append(arr[1][index]);
                number -= c;
            }
        }

        return romanText.toString();
    }
}
