package 树.前缀树;

import java.util.LinkedList;
import java.util.List;

//前缀树+回溯法
public class 单词搜索2 {
    private List<String> res = new LinkedList<>();
    private int[] px = {1, 0, -1, 0};
    private int[] py = {0, -1, 0, 1};

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            insert(word);
        }
        int lenx = board.length;
        int leny = board[0].length;
        for (int i = 0; i < lenx; i++) {
            for (int j = 0; j < leny; j++) {
                boolean[][] visited = new boolean[lenx][leny];
                find(i, j, "", visited, board);
            }
        }
        return res;
    }

    public void find(int x, int y, String sb, boolean[][] visited, char[][] board) {
        if (x >= 0 && x < board.length && y >= 0 && y < board[0].length && !visited[x][y]) {
            if (search(sb) && !res.contains(sb)) {
                res.add(sb);
            }
            if (!startWith(sb)) {
                return;
            }
            visited[x][y] = true;
            String s = sb + board[x][y];
            for (int i = 0; i < 4; i++) {
                int newx = x + px[i];
                int newy = y + py[i];
                find(newx, newy, s, visited, board);
            }
            visited[x][y] = false;
        }
    }


    //字典树部分
    private class TireNode {
        boolean isEnd;
        TireNode[] nodes;

        TireNode() {
            isEnd = false;
            nodes = new TireNode[26];
        }
    }

    TireNode root = new TireNode();

    private void insert(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                cur.nodes[k] = new TireNode();
            }
            cur = cur.nodes[k];
        }
        cur.isEnd = true;
    }

    private boolean search(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                return false;
            }
            cur = cur.nodes[k];
        }
        return cur.isEnd;
    }

    private boolean startWith(String word) {
        TireNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                return false;
            }
            cur = cur.nodes[k];
        }
        return true;
    }

    public static void main(String[] args) {
        单词搜索2 a = new 单词搜索2();
        String[] word = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        System.out.println(a.findWords(board, word));
    }
}
