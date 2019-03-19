package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N69 {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }
        int temp = x / 2;
        int left = 0;
        int right = x;
        while (true) {
            if (temp <= x / temp && (temp + 1) > x / (temp + 1)) {
                return temp;
            } else if (temp > x / temp) {
                right = temp;
            } else {
                left = temp;
            }
            temp = left + (right - left) / 2;
        }
    }
}
