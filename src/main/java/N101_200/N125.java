package N101_200;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N125 {
    public boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i <= j; i++, j--) {
            while (i < j && isNotAlphanumeric(chars[i])) {
                i++;
            }
            while (i < j && isNotAlphanumeric(chars[j])) {
                j--;
            }
            if (!equalsIgnoreCase(chars[i], chars[j])) {
                return false;
            }
        }
        return true;
    }

    private boolean isNotAlphanumeric(char c) {
        return !Character.isAlphabetic(c) && !Character.isDigit(c);
    }

    private boolean equalsIgnoreCase(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }
}
