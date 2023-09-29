class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        generateCombinations(n, k, 1, new ArrayList<>(), combinations);
        return combinations;
    }

    private void generateCombinations(int n, int k, int start, List<Integer> current, List<List<Integer>> combinations) {
        if (k == 0) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i <= n; i++) {
            current.add(i);
            generateCombinations(n, k - 1, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }
}
