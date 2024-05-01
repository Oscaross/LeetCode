class Solution {


    private HashMap<Character, String> map = new HashMap<>();

    public Solution()
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> ret = new ArrayList<>();

        // Deal with the empty case
        if(digits.equals("")) return ret;
        // Populate an ArrayList of strings for the possible combinations ("23" -> "abc", "def")
        char[] intChars = digits.toCharArray();
        ArrayList<String> strDigits = new ArrayList<>();

        for(int i = 0; i < intChars.length - 1; i++)
        {
            String chars = map.get(intChars[i]);
            ArrayList<String> result = cartesianProduct(map.get(intChars[i]), map.get(intChars[i+1]));

            for(String s : result)
            {
                ret.add(s);
            }
        }

        // Iterate over the ArrayList to make the final return value of all possible permutations.

        return ret;
    }

    // Returns the cartesian product of a set of chars (string) A x B. Must be given non-empty String a and b
    public ArrayList<String> cartesianProduct(String a, String b)
    {
        ArrayList<String> ret = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Deal with string b or string a being empty/null, if this is the case then we need to just return all characters in the one not null string

        if(a == null)
        {
            return extractEmptyChars(b);
        }
        else if(b == null)
        {
            return extractEmptyChars(a);
        }

        while(a.length() > i)
        {
            ret.add("" + a.charAt(i) + b.charAt(j));
            j++;
            if(j == b.length()) 
            {
            	i++;
                j = 0;
            }
        }

        return ret;
    }

    public ArrayList<String> extractEmptyChars(String s)
    {
        ArrayList<String> ret = new ArrayList<>();

        char[] c = s.toCharArray();
        for(Character cc : c)
        {
            ret.add(cc.toString());
        }

        return ret;
    }
}

