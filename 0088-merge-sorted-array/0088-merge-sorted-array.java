class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialize pointers for nums1, nums2, and the merged array
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        int mergedPtr = m + n - 1;

        // Merge the two arrays from the back to the front
        while (ptr1 >= 0 && ptr2 >= 0) {
            if (nums1[ptr1] >= nums2[ptr2]) {
                nums1[mergedPtr] = nums1[ptr1];
                ptr1--;
            } else {
                nums1[mergedPtr] = nums2[ptr2];
                ptr2--;
            }
            mergedPtr--;
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (ptr2 >= 0) {
            nums1[mergedPtr] = nums2[ptr2];
            ptr2--;
            mergedPtr--;
        }
    }
}
