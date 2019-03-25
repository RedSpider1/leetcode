package N1_100;

public class N6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        int n = s.length();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                stringBuilder.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    stringBuilder.append(s.charAt(j + cycleLen - i));
            }
        }
        return stringBuilder.toString();
    }
}
