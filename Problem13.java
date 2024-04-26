class Solution {

    public HashMap<Character, Integer> numeralToInt = new HashMap<>();
    public Solution()
    {
        // Initialise HashMap with values
        numeralToInt.put('I', 1);
        numeralToInt.put('V', 5);
        numeralToInt.put('X', 10);
        numeralToInt.put('L', 50);
        numeralToInt.put('C', 100);
        numeralToInt.put('D', 500);
        numeralToInt.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] numerals = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for(char c : numerals)
        {
            stack.push(c);
        }

        System.out.println(stack);

        int accum = 0;

        while(stack.size() > 1)
        {
            int charAsInt = numeralToInt.get(stack.pop());
            // If our integer is a V, X, L, C, D or M then subtraction is possible. ie. i != I
            boolean checkSubtract = (charAsInt != 1);

            if(checkSubtract && (stack.peek() == 'I' || stack.peek() == 'X' || stack.peek() == 'C'))
            {
                int z = stack.pop();
                System.out.println("In here with " + charAsInt + " " + z);
                accum += (charAsInt - z);
            }
            else
            {
                accum += charAsInt;
            }
        }
        // Add the last element from the stack
        accum += numeralToInt.get(stack.pop());

        return accum;
    }
}
