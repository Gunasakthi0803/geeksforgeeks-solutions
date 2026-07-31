public class Solution {
    public int surfaceArea(int[][] grid) {
        int n = grid.length;
        int area = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] > 0) {
                    // Each cube has 6 faces, subtract 2 for each internal face (stacked cubes)
                    area += grid[i][j] * 6 - (grid[i][j] - 1) * 2;
                }

                // Subtract shared faces with neighbor above
                if (i > 0) {
                    area -= Math.min(grid[i][j], grid[i - 1][j]) * 2;
                }

                // Subtract shared faces with neighbor to the left
                if (j > 0) {
                    area -= Math.min(grid[i][j], grid[i][j - 1]) * 2;
                }
            }
        }

        return area;
    }
}