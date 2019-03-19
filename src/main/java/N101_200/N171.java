package N101_200;

public class N171 {
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int ratio = 1;
        for (int i = chars.length - 1; i >= 0; i--) {
            result += getNumberOfOneChar(chars[i]) * ratio;
            ratio *= 26;
        }
        return result;
    }

    private int getNumberOfOneChar(char c) {
        return c - 'A' + 1;
    }
}
