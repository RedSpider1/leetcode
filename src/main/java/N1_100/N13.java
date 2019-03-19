package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N13 {
    public int romanToInt(String s) {
        int result = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (i < chars.length - 1 && isSpecial(chars[i], chars[i + 1])) {
                result += getSpecial(chars[i], chars[i + 1]);
                i++;
            } else {
                result += chat2inti(chars[i]);
            }
        }
        return result;
    }

    private int chat2inti(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    private boolean isSpecial(char low, char high) {
        return (low == 'I' && (high == 'V' || high == 'X')) ||
                (low == 'X' && (high == 'L' || high == 'C')) ||
                (low == 'C' && (high == 'D' || high == 'M'));

    }

    private int getSpecial(char low, char high) {
        return chat2inti(high) - chat2inti(low);
    }
}
