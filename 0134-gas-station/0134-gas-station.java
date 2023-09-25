class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;  // Total gas available
        int currentGas = 0;  // Current gas in the tank
        int startStation = 0;  // Starting station
        
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            
            // Add the difference to the current gas in the tank
            currentGas += diff;
            totalGas += diff;
            
            // If currentGas becomes negative, we can't start from the current station
            if (currentGas < 0) {
                currentGas = 0;
                startStation = i + 1; // Update the starting station
            }
        }
        
        // If totalGas is negative, it means there is no solution
        if (totalGas < 0) {
            return -1;
        }
        
        return startStation;
    }
}
