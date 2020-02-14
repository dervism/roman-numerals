package no.dervis.romannums;

public class RomanNums3 {

    String[] arr = new String[] {"900", "500", "400", "100", "90", "50", "40", "10", "9", "5", "4", "1"};
    String[] str = new String[] {"CM", "D", "CD", "C", "XC", "L", "XL", "X" ,"IX", "V", "IV", "I"};

    public String toRoman(int number) {
        StringBuilder romanText = new StringBuilder();

        while (number > 0) {
            int index = 0, c;
            while ((c = Integer.parseInt(arr[index])) > number) index++;
            while(number >= c) {
                romanText.append(str[index]);
                number -= c;
            }
        }

        return romanText.toString();
    }
}