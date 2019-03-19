package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N53 {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int currentMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            result = Math.max(result, currentMax);
        }
        return result;
    }
}
