import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }

        // Sort the balloons by their end points
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;  // The first arrow is shot at the end of the first balloon
        int end = points[0][1];

        for (int i = 1; i < points.length; i++) {
            int[] balloon = points[i];

            // If the balloon doesn't overlap with the common region, we need a new arrow
            if (balloon[0] > end) {
                arrows++;
                end = balloon[1];  // Update the common region
            }
        }

        return arrows;
    }
}
