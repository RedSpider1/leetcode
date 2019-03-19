package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N70 {
    public int climbStairs(int n) {
        if (n <= 3) {
            return n;
        } else {
            int result = 3;
            int temp = 2;
            for (int i = 4; i <= n; i++) {
                result = result + temp;
                temp = result - temp;
            }
            return result;
        }
    }
}
