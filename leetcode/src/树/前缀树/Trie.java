package 树.前缀树;
//实际上是一个26叉树
public class Trie {
    private class TrieNode {
        boolean isEnd = false;
        TrieNode[] nodes = new TrieNode[26];
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                cur.nodes[k] = new TrieNode();
            }
            cur = cur.nodes[k];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                return false;
            }
            cur = cur.nodes[k];
        }
        return cur.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int k = prefix.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                return false;
            }
            cur = cur.nodes[k];
        }
        return true;
    }
}
