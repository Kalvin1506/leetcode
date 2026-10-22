class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) cnt.put(x, cnt.getOrDefault(x, 0) + 1);

        for (int x : arr) {
            if (cnt.get(x) == 0) continue;
            if (x < 0 && x % 2 != 0) return false; // For example: arr=[-5, -2, 1, 2], x = -5, there is no x/2 pair to match
            int y = x > 0 ? x*2 : x/2;
            if (cnt.getOrDefault(y, 0) == 0) return false; // Don't have the corresponding `y` to match with `x` -> Return IMPOSSIBLE!
            cnt.put(x, cnt.get(x) - 1);
            cnt.put(y, cnt.get(y) - 1);
        }
        return true;
    }
}