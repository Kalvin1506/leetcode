class Solution {
    public long minimumRemoval(int[] A) {
        long N = A.length, ans = Long.MAX_VALUE, sum = 0;
        for (int n : A) sum += n;
        Arrays.sort(A);
        for (int i = 0; i < N; ++i) ans = Math.min(ans, sum - (N - i) * A[i]);
        return ans;
    }
}