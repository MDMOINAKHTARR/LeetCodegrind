class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int[] lastSeen = new int[32]; // Tracks the last seen index of each bit

        // Traverse from the end of the array to the beginning
        for (int i = n - 1; i >= 0; i--) {
            // For each bit from 0 to 31
            for (int b = 0; b < 32; b++) {
                if (((nums[i] >> b) & 1) == 1) {
                    lastSeen[b] = i; // Update where we last saw this bit
                }
            }

            // Compute the farthest index we need to go to cover all needed bits
            int maxReach = i;
            for (int b = 0; b < 32; b++) {
                if (lastSeen[b] != 0 || ((nums[n - 1] >> b) & 1) == 1) {
                    maxReach = Math.max(maxReach, lastSeen[b]);
                }
            }

            res[i] = maxReach - i + 1;
        }

        return res;
    }
}
