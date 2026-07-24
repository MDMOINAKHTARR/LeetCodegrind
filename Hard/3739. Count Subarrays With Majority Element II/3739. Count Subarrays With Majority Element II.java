class Solution {
    class Fenwick {
        int[] bit;

        Fenwick(int n) {
            bit = new int[n + 2];
        }

        void update(int idx, int val) {
            while (idx < bit.length) {
                bit[idx] += val;
                idx += idx & -idx;
            }
        }

        int query(int idx) {
            int sum = 0;
            while (idx > 0) {
                sum += bit[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int offset = n + 2;

        Fenwick ft = new Fenwick(2 * n + 5);

        int prefix = 0;
        long ans = 0;

        // Insert prefix sum = 0
        ft.update(offset, 1);

        for (int x : nums) {
            if (x == target)
                prefix++;
            else
                prefix--;

            // Count previous prefix sums < current prefix
            ans += ft.query(prefix + offset - 1);

            // Insert current prefix sum
            ft.update(prefix + offset, 1);
        }

        return ans;
    }
}
