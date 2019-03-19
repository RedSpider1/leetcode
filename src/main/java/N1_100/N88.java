package N1_100;

/**
 * @author Yasin Shaw
 * @version v1.0
 */
public class N88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        while (i - j < m && j < n) {
            if (nums1[i] > nums2[j]) {
                System.arraycopy(nums1, i, nums1, i + 1, nums1.length - i - 1);
                nums1[i] = nums2[j++];
            } else {
                i++;
            }
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, i, n - 1 - j);
        }
    }
}