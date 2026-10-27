class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { 1, 1 }, { -1, -1 }, { 1, -1 }, { -1, 1 } };

        int level = 0;
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[] { 0, 0 });
        grid[0][0] = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-- > 0) {
                int[] curr = q.poll();

                int i = curr[0];
                int j = curr[1];

                if (i == n - 1 && j == n - 1)
                    return level + 1;

                for (int[] dir : dirs) {
                    int _i = i + dir[0];
                    int _j = j + dir[1];

                    if (_i >= 0 && _i < n && _j >= 0 && _j < n && grid[_i][_j] == 0) {
                        q.offer(new int[] { _i, _j });
                        grid[_i][_j] = 1;
                    }
                }
            }

            level++;
        }

        return -1;
    }
}