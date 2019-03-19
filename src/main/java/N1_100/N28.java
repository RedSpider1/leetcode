package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N28 {
    public int strStr(String haystack, String needle) {
        if (needle == null || needle.isEmpty()) {
            return 0;
        } else {
            return haystack.indexOf(needle);
        }
    }
}
