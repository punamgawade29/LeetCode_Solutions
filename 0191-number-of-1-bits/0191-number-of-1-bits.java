public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1); // Clear the rightmost '1' bit
            count++;
        }
        return count;
    }
}
