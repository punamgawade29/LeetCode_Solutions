class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        char[] charArray = s.toCharArray();
        int len = charArray.length;
        StringBuilder[] rows = new StringBuilder[Math.min(numRows, len)];
        
        for (int i = 0; i < rows.length; i++) {
            rows[i] = new StringBuilder();
        }
        int rowIndex = 0;
        boolean goingDown = false;
        
        for (char c : charArray) {
            rows[rowIndex].append(c);
            
            if (rowIndex == 0 || rowIndex == numRows - 1) {
                goingDown = !goingDown;
            }
            
            rowIndex += goingDown ? 1 : -1;
        }
        
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row.toString());
        }
        
        return result.toString();
    }
}
