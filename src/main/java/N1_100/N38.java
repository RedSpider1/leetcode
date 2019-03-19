package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N38 {
    public String countAndSay(int n) {
        String sequence = "1";
        for (int i = 1; i < n; i++) {
            sequence = getNextSequence(sequence);
        }
        return sequence;
    }

    private String getNextSequence(String lastSequence) {
        char[] chars = lastSequence.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if (chars[j] != chars[i]) {
                    stringBuilder.append(j - i);
                    stringBuilder.append(chars[i]);
                    i = j;
                }
                if (j == chars.length - 1) {
                    stringBuilder.append(chars.length - i);
                    stringBuilder.append(chars[i]);
                    i = chars.length;
                    break;
                }
            }
        }
        return stringBuilder.toString();
    }
}
