import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0; // If endWord is not in wordList, transformation is not possible
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        
        queue.offer(beginWord);
        visited.add(beginWord);
        
        int transformations = 1; // Start with 1 since we already have beginWord
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                
                char[] wordArray = currentWord.toCharArray();
                
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != originalChar) {
                            wordArray[j] = c;
                            String transformedWord = new String(wordArray);
                            
                            if (transformedWord.equals(endWord)) {
                                return transformations + 1; // Transformation path found
                            }
                            
                            if (wordSet.contains(transformedWord) && !visited.contains(transformedWord)) {
                                queue.offer(transformedWord);
                                visited.add(transformedWord);
                            }
                        }
                    }
                    
                    wordArray[j] = originalChar; // Revert back to original word
                }
            }
            
            transformations++;
        }
        
        return 0; // No transformation path found
    }
}
