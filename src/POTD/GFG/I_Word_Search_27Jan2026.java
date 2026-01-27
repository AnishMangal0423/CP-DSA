package POTD.GFG;

public class I_Word_Search_27Jan2026 {

    /**
     * WORD SEARCH (DFS + Backtracking)
     *
     * INTUITION:
     * We try to form the given word starting from every cell in the grid.
     * From each starting cell, we explore 4 possible directions (up, down, left, right)
     * using DFS.
     *
     * Since a cell cannot be reused in the same path, we maintain a visited[][] array
     * to avoid revisiting cells and creating cycles.
     *
     * We use BACKTRACKING:
     * 1. Mark cell as visited
     * 2. Explore neighbors
     * 3. Unmark cell before returning (restore state)
     *
     * We stop early as soon as the full word is matched.
     *
     *
     * TIME COMPLEXITY:
     * O(m * n * 3^L)
     * m = rows, n = columns, L = length of word
     *
     * Why 3^L and not 4^L?
     * From the first cell we can go in 4 directions,
     * but after that we cannot go back to the previous cell (because visited),
     * so branching factor becomes at most 3.
     *
     *
     * SPACE COMPLEXITY:
     * O(m * n)  -> visited array
     * O(L)      -> recursion stack depth
     *
     *
     * COMMON MISTAKE (Earlier Version):
     * --------------------------------------
     * Not marking cells as visited allows cycles like:
     *
     * A → B → A → B → A → B ...
     *
     * Even though recursion depth is limited to L,
     * the number of possible paths explodes exponentially.
     *
     * Example:
     * Grid full of 'A' and word = "AAAAAAAA"
     *
     * Without visited:
     * Each step had 4 choices → Total paths ≈ 4^L
     *
     * With visited:
     * Cannot go back → choices reduce to 3 → Total paths ≈ 3^L
     *
     * That reduction is the difference between passing and TLE.
     */

    public class Solution {

        public static boolean isWordExist(char[][] board, String word) {
            int rows = board.length;
            int cols = board[0].length;

            // Pruning: word longer than total cells → impossible
            if (word.length() > rows * cols) return false;

            boolean[][] visited = new boolean[rows][cols];

            // Direction vectors (Left, Up, Right, Down)
            int[] dx = {0, -1, 0, 1};
            int[] dy = {-1, 0, 1, 0};

            // Try starting DFS from every cell
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (board[i][j] == word.charAt(0)) {
                        visited[i][j] = true;

                        if (dfs(board, word, 0, i, j, visited, dx, dy))
                            return true;

                        visited[i][j] = false; // backtrack
                    }
                }
            }
            return false;
        }

        private static boolean dfs(char[][] board, String word, int index,
                            int i, int j, boolean[][] visited,
                            int[] dx, int[] dy) {

            // If last character matched → word found
            if (index == word.length() - 1) return true;

            int rows = board.length;
            int cols = board[0].length;

            // Explore 4 directions
            for (int k = 0; k < 4; k++) {
                int x = i + dx[k];
                int y = j + dy[k];

                // Check bounds + not visited + next char match
                if (x >= 0 && y >= 0 && x < rows && y < cols &&
                        !visited[x][y] &&
                        board[x][y] == word.charAt(index + 1)) {

                    visited[x][y] = true;

                    if (dfs(board, word, index + 1, x, y, visited, dx, dy))
                        return true;

                    visited[x][y] = false; // backtracking step
                }
            }

            return false;
        }

        // 🔽 MAIN METHOD FOR INTELLIJ RUN
        public static void main(String[] args) {

            char[][] board = {
                    {'A', 'B', 'C', 'E'},
                    {'S', 'F', 'C', 'S'},
                    {'A', 'D', 'E', 'E'}
            };

            String word1 = "ABCCED";  // true
            String word2 = "SEE";     // true
            String word3 = "ABCB";    // false (cannot reuse same cell)

            System.out.println("Word " + word1 + " exists: " + isWordExist(board, word1));
            System.out.println("Word " + word2 + " exists: " + isWordExist(board, word2));
            System.out.println("Word " + word3 + " exists: " + isWordExist(board, word3));
        }
    }

}
