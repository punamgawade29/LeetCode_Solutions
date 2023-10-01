public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1; // Left-shift the result by 1 bit to make space for the next bit.
            result |= (n & 1); // Get the rightmost bit of n and set it as the rightmost bit of the result.
            n >>>= 1; // Right-shift n by 1 bit to get the next bit for the next iteration.
        }
        return result;
    }
}
