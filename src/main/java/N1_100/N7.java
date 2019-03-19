package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N7 {
    public int reverse(int x) {
        boolean isPositive = x > 0;
        int result = 0;
        x = Math.abs(x);
        while (x > 0) {
            if ((Integer.MAX_VALUE - x % 10) / 10 < result) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return isPositive ? result : result * -1;
    }
}
