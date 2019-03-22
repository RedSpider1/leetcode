package N1_100

import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.max

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var maxLength = 0
        val n = s.length
        val map = HashMap<Char, Int>()
        var i = 0
        for (j in 0 until n) {
            if (s[j] in map) {
                i = max(map.get(s[j])!!, i)
            }
            maxLength = max(maxLength, j - i + 1)
            map.put(s[j], j + 1)
        }
        return maxLength
    }

    @Test
    fun test() {
        assertEquals(lengthOfLongestSubstring("abcabcbb"), 3)
    }
}