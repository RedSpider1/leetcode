package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int originalX = x;
        int revert = 0;

        while (x > 0) {
            revert = revert * 10 + x % 10;
            x /= 10;
        }

        return originalX == revert;
    }
}
