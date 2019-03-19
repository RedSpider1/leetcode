package N1_100;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N1 {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer anotherNumber = map.get(target - nums[i]);
            if (anotherNumber != null) {
                return new int[]{i, anotherNumber};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{-1, -1};
    }
}
