class Solution {

    private void findCombinations(int idx, int[] candidates, int target, List<List<Integer>> ans, List<Integer> ds) {
        if (idx == candidates.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }

        if (candidates[idx] <= target) {
            ds.add(candidates[idx]);
            findCombinations(idx, candidates, target - candidates[idx], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(idx + 1, candidates, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }
}
