import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramGroups = new HashMap<>();
        
        for (String str : strs) {
            // Sort the characters in the string to get a unique key
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            
            // If the key exists in the hashmap, add the string to the corresponding group
            // Otherwise, create a new group with the key
            if (anagramGroups.containsKey(sortedStr)) {
                anagramGroups.get(sortedStr).add(str);
            } else {
                List<String> group = new ArrayList<>();
                group.add(str);
                anagramGroups.put(sortedStr, group);
            }
        }
        
        // Convert the values (lists of anagrams) of the hashmap to a list of lists
        List<List<String>> result = new ArrayList<>(anagramGroups.values());
        
        return result;
    }
}
