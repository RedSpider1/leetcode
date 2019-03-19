package N101_200;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N136 {
    public int singleNumber(int[] nums) {
        int ans = 0;

        int len = nums.length;
        for (int i = 0; i != len; i++)
            ans ^= nums[i];

        return ans;
    }
}
