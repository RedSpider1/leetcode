package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N67 {
    public String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        boolean carry = false;
        int i = aChars.length - 1, j = bChars.length - 1;
        while (i >= 0 || j >= 0) {
            int temp;
            if (i < 0) {
                temp = charToInt(bChars[j]);
            } else if (j < 0) {
                temp = charToInt(aChars[i]);
            } else {
                temp = charToInt(aChars[i]) + charToInt(bChars[j]);
            }
            if (carry) {
                temp += 1;
            }
            if (temp > 1) {
                temp -= 2;
                carry = true;
            } else {
                carry = false;
            }
            if (i > j) {
                aChars[i] = intToChar(temp);
            } else {
                bChars[j] = intToChar(temp);
            }
            i--;
            j--;
        }
        char[] maxLengthChars = getMaxLengthChars(aChars, bChars);
        if (carry) {
            char[] resultChars = new char[maxLengthChars.length + 1];
            resultChars[0] = '1';
            System.arraycopy(maxLengthChars, 0, resultChars, 1, maxLengthChars.length);
            return String.valueOf(resultChars);
        } else {
            return String.valueOf(maxLengthChars);
        }
    }

    private int charToInt(char c) {
        if (c == '0') {
            return 0;
        } else if (c == '1') {
            return 1;
        } else {
            throw new RuntimeException("invalid char: " + c);
        }
    }

    private char intToChar(int i) {
        if (i == 0) {
            return '0';
        } else if (i == 1) {
            return '1';
        } else {
            throw new RuntimeException("invalid integer: " + i);
        }
    }

    private char[] getMaxLengthChars(char[] a, char[] b) {
        if (a.length > b.length) {
            return a;
        } else {
            return b;
        }
    }
}
