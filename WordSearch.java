
// Time Complexity : O(m*n*(3^k))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  Yes, had to learn

/*
 * Word Search(https://leetcode.com/problems/word-search/)
 * 
 * Backtracking is possible only with DFS, because we have the parent info at each node to update and backtrack.
 * We start at each i & j and if result is false we do a DFS from that point until we get result (true), if not we return false;
 * 
 * helper function does the DFS: base condition if we current charIndex meets the length of the word that means recurrion ended on positive note
 * 
 * if the char at currentIndex is same as board then for each i, j find its neighbouring children and do the DFS in recursive
 * 
 * we have to handle the edge cases, what if the i,j are out of bound?
 *<Backtracking>
 * A nice way to track if the word is used in the current recurrsion is by changing the current board value and once the path is done, replace it with the charAt currentIndex.
 *<Backtracking>
 * 
 */

public class WordSearch {
    boolean result;
    int[][] directions;

    int m, n;

    public boolean exist(char[][] board, String word) {
        directions = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!result) {
                    helper(board, i, j, 0, word);
                } else {
                    break;
                }
            }
        }
        return result;

    }

    private void helper(char[][] board, int i, int j, int charIndex, String word) {
        // base condition
        if (charIndex == word.length()) {
            result = true;
            return;
        }

        if (i < 0 || j < 0 || i == m || i == n || board[i][j] == '#')
            return;

        // logic
        if (board[i][j] == word.charAt(charIndex)) {
            board[i][j] = '#'; // marking as visted
            for (int[] direction : directions) {
                int nR = direction[0] + i;
                int nC = direction[1] + j;
                helper(board, nR, nC, charIndex + 1, word);

            }
            board[i][j] = word.charAt(charIndex); // backtracking
        }
    }

}
