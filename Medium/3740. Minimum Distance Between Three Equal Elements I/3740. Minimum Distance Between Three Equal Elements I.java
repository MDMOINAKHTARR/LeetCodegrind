class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, java.util.List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        
        int ans = Integer.MAX_VALUE;
        
        for (java.util.List<Integer> list : map.values()) {
            if (list.size() >= 3) {
                for (int i = 0; i <= list.size() - 3; i++) {
                    int dist = list.get(i + 2) - list.get(i);
                    ans = Math.min(ans, dist);
                }
            }
        }
        
        return ans == Integer.MAX_VALUE ? -1 : 2 * ans;
    }
}
