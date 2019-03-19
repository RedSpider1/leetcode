package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N27 {
    public int removeElement(int[] nums, int val) {
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }
}
