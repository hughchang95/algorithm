package BFS_DFS;

public class 矩阵中的路径 {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int x, int y, int mark) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(mark)) {
            return false;
        }
        if (mark == word.length() - 1) {
            return true;
        }
        char c = board[x][y];
        board[x][y] = '/';
        boolean res = dfs(board, word, x + 1, y, mark + 1) ||
                dfs(board, word, x, y + 1, mark + 1) ||
                dfs(board, word, x - 1, y, mark + 1) ||
                dfs(board, word, x, y - 1, mark + 1);
        board[x][y] = c;
        return res;
    }


    public static void main(String[] args) {
//        char[][] board = new char[][]{{'A', 'B'}};
//        String word = "BA";
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'F'}};
        String word = "ABCCED";
        矩阵中的路径 a = new 矩阵中的路径();
        System.out.println(a.exist(board, word));
    }
}
