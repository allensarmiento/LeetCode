class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        
        for (int i = 0; i < getSmallestWordCount(strs); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != ch) {
                    return result.toString();
                }
            }
            result.append(ch);
        }
        
        return result.toString();
    }
    
    private int getSmallestWordCount(String[] strs) {
        if (strs.length == 0) return 0;
        
        int smallestWordCount = Integer.MAX_VALUE;
        
        for (String str : strs) {
            if (str.length() < smallestWordCount) {
                smallestWordCount = str.length();
            }
        }
        
        return smallestWordCount;
    }
}