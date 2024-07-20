class Solution {
    public int strStr(String haystack, String needle) {
        // Check if needle is empty
        if (needle.isEmpty()) {
            return 0;
        }
        
        // Get the lengths of haystack and needle
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        // Loop through the haystack to find the needle
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if the substring of haystack starting at i matches needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i;
            }
        }
        
        // If needle is not found, return -1
        return -1;
    }
}
