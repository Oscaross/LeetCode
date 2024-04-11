public class Solution
{
    /**
     * Find the longest common prefix string amongst a given array of strings.
     * @param strs the array of strings to find the longest common prefix of.
     * @return the longest common prefix, as a string. If no such string exists, an empty string.
     */
    public String longestCommonPrefix(String[] strs)
    {
        // Initially, we simply take the first string from the array as the comparison
        String comp = strs[0];

        // Iteratively search the array from the first given string to the last string in the array
        for(int i = 1; i < strs.length; i++)
        {
            // Will store the longest common prefix found in this iteration
            String temp = "";
            // The current string we are evaluating, as an array of characters
            char[] curr = strs[i].toCharArray();

            // For each character in the current string, check whether it matches the string we are comparing character at that index
            for(int j = 1; j < comp.length(); j++)
            {
                char currentChar = comp.charAt(j);
                if(currentChar == curr[i]) temp += currentChar;
                else break;
            }
            // Set comp string we have found to be the temporary string we have been looking at
            comp = temp;
        }

        return comp;
    }
}
