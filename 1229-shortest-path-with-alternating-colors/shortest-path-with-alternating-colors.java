class Solution {
    void dfs(List<List<Integer>> x, List<List<Integer>> y, int[] vis1, int[] vis2, int curr, int cnt, int[] ans) {
        if (vis1[curr] <= cnt) return;
        vis1[curr] = cnt;
        ans[curr] = Math.min(ans[curr], cnt);
        for (int i = 0; i < y.get(curr).size(); i++) dfs(y, x, vis2, vis1, y.get(curr).get(i), cnt + 1, ans);
    }

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> red = new ArrayList<>(), blue = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }
        int[] ans = new int[n], vis1 = new int[n], vis2 = new int[n], vis3 = new int[n], vis4 = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE);
        Arrays.fill(vis1, Integer.MAX_VALUE);
        Arrays.fill(vis2, Integer.MAX_VALUE);
        Arrays.fill(vis3, Integer.MAX_VALUE);
        Arrays.fill(vis4, Integer.MAX_VALUE);
        ans[0] = 0;
        vis2[0] = 0;
        vis3[0] = 0;
        int l = redEdges.length, m = blueEdges.length;
        for (int i = 0; i < l; i++) red.get(redEdges[i][0]).add(redEdges[i][1]);
        for (int i = 0; i < m; i++) blue.get(blueEdges[i][0]).add(blueEdges[i][1]);
        for (int i = 0; i < red.get(0).size(); i++) dfs(red, blue, vis1, vis2, red.get(0).get(i), 1, ans);
        for (int i = 0; i < blue.get(0).size(); i++) dfs(blue, red, vis3, vis4, blue.get(0).get(i), 1, ans);
        for (int i = 0; i < n; i++) if (ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        return ans;
    }
}