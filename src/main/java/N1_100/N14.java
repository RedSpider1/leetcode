package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            int lastSameIndex = 0;
            int length = strs[0].length();
            for (int i = 0; i < length; i++, lastSameIndex++) {
                for (int j = 0; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                        return strs[0].substring(0, i);
                    }
                }
            }
            return strs[0].substring(0, lastSameIndex);
        }
    }
}
