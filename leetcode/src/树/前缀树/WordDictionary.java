package 树.前缀树;

class WordDictionary {
    private class WordNode {
        boolean isEnd;
        WordNode[] nodes;

        WordNode() {
            isEnd = false;
            nodes = new WordNode[26];
        }
    }

    WordNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new WordNode();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int k = word.charAt(i) - 'a';
            if (cur.nodes[k] == null) {
                cur.nodes[k] = new WordNode();
            }
            cur = cur.nodes[k];
        }
        cur.isEnd = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return doSearch(word, root);
    }

    public boolean doSearch(String word, WordNode root) {
        WordNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            //递归搜索
            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (cur.nodes[j] != null) {
                        if (doSearch(word.substring(i + 1), cur.nodes[j])) {
                            return true;
                        }
                    }
                }
                return false;
            }
            if (cur.nodes[c - 'a'] == null) {
                return false;
            }
            cur = cur.nodes[c - 'a'];
        }
        return cur.isEnd;

    }
}
