package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N66 {
    public int[] plusOne(int[] digits) {
        int[] result;
        boolean carry = true;
        for (int i = digits.length - 1; i >= 0 && carry; i--) {
            digits[i] += 1;
            if (digits[i] == 10) {
                digits[i] = 0;
            } else {
                carry = false;
            }
        }
        if (carry) {
            result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = 1;
        } else {
            result = digits;
        }
        return result;
    }
}
