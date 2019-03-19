package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N35 {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}
