package N1_100

import junit.framework.Assert.assertEquals
import org.junit.Test

class N169 {
    fun majorityElement(nums: IntArray): Int {
        var result = 0
        for (i in 0..31) {
            var ones = 0
            var zeros = 0
            for (j in 0 until nums.size) {
                if ((nums[j] and (1.shl(i))) != 0) {
                    ones++
                } else {
                    zeros++
                }
            }
            if (ones > zeros) {
                result = 1.shl(i) or result
            }
        }
        return result
    }

    @Test
    public fun test() {
        assertEquals(majorityElement(intArrayOf(3, 2, 3)), 3)
        assertEquals(majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)), 2)
        assertEquals(majorityElement(intArrayOf(6, 5, 5)), 5)
    }
}