class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        
        Map<Character, Character> sToT = new HashMap<>();
        Map<Character, Character> tToS = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // Check mapping from s to t
            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false; // sChar maps to a different character in t
                }
            } else {
                sToT.put(sChar, tChar);
            }
            
            // Check mapping from t to s
            if (tToS.containsKey(tChar)) {
                if (tToS.get(tChar) != sChar) {
                    return false; // tChar maps to a different character in s
                }
            } else {
                tToS.put(tChar, sChar);
            }
        }
        
        return true;
    }
}
