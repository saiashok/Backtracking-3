
// Time Complexity : n*n!*n
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :  Yes
// Any problem you faced while coding this :  Yes, had to learn 

/*
 * https://leetcode.com/problems/n-queens/description/
 * 
 * We need to place one queen in each row, so we start at row 0 and place the queen on the board and check the combinations at each column position;
 * 
 * at each i, j (row, column) we have to check for possibility to place the queen there.
 * 
 * to check if a queen can be placed at a particualr position we have to check if we have queen (on the upper side of the matrix) at top-Up, top-left-diagonal, top-right-diagonal
 * 
 */
import java.util.*;

public class NQueens {
    List<List<String>> result;
    boolean[][] board;

    public List<List<String>> solveNQueens(int n) {
        this.result = new ArrayList<>();
        this.board = new boolean[n][n];

        helper(0, n);
        return result;

    }

    private void helper(int i, int n) {// i is row index
        // base
        if (i == n) {
            List<String> resultSub = new ArrayList<>();
            for (int r = 0; r < n; r++) {
                StringBuilder resultString = new StringBuilder();
                for (int c = 0; c < n; c++) {
                    if (board[r][c]) {
                        resultString.append("Q");
                    } else {
                        resultString.append(".");
                    }
                }
                resultSub.add(resultString.toString());
            }
            result.add(resultSub);
            return;

        }

        // logic
        for (int j = 0; j < n; j++) { // each i will have j possibilities- column

            if (isPossible(i, j, n)) {
                board[i][j] = true;
                helper(i + 1, n);
                board[i][j] = false; // back tracking
            }

        }

    }

    private boolean isPossible(int i, int j, int n) {
        // up
        int k = i, m = j;
        while (k >= 0) {
            if (board[k][m])
                return false;
            k--;
        }

        // left diagonal
        k = i;// rest so the initial values are intact for next traversel.
        m = j;
        while (k >= 0 && m >= 0) {
            if (board[k][m])
                return false;
            k--;
            m--;
        }

        // right diagonal
        k = i; // rest so the initial values are intact for next traversel.
        m = j;

        while (k >= 0 && m < n) {
            if (board[k][m])
                return false;
            k--;
            m++;
        }

        return true;

    }
}
