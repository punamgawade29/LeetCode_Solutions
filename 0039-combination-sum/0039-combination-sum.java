class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(candidates, target, 0, new ArrayList<>(), combinations);
        return combinations;
    }

    private void generateCombinations(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> combinations) {
        if (target == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                current.add(candidates[i]);
                generateCombinations(candidates, target - candidates[i], i, current, combinations);
                current.remove(current.size() - 1);
            }
        }
    }
}
