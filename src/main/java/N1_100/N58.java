package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N58 {
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] chars = s.toCharArray();
        int position = chars.length - 1;
        while (position >= 0 && chars[position] == ' ') {
            position--;
        }
        while (position >= 0 && chars[position] != ' ') {
            position--;
            count++;
        }
        return count;
    }
}
