class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        Set<String> result = new HashSet<>();

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, root, result);
            }
        }

        return new ArrayList<>(result);
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.word = word;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, Set<String> result) {
        char ch = board[i][j];
        int index = ch - 'a';

        if (ch == '#' || node.children[index] == null) {
            return;
        }

        node = node.children[index];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid duplicate results
        }

        board[i][j] = '#'; // Mark the cell as visited

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : dirs) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < board.length && newCol >= 0 && newCol < board[0].length) {
                dfs(board, newRow, newCol, node, result);
            }
        }

        board[i][j] = ch; // Restore the cell
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
