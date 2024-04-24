class Solution {
    public int strStr(String haystack, String needle) {

        char firstChar = needle.charAt(0);

        if(haystack.length() < needle.length()) return -1;

        for(int i = 0; i < haystack.length(); i++) {
            // If our character matches the first character in the search, iterate over each character in the      needle and check for a match
            if(haystack.charAt(i) == firstChar) {
                
                int z = 0;
                boolean found = true;

                for(int j = i; j < i + needle.length(); j++) {
                    
                    if(haystack.charAt(j) != needle.charAt(z))
                    {
                        found = false;
                        break;
                    }

                    z++;
                }

                if(found) return i;
            }
        }

        return -1;
    }
}
