import java.util.Stack;

/**
 * PROBLEM 7: Reverse Integer
 */
class Solution {
    public int reverse(int x)
    {
        // Store the digits on a stack
        Stack<Integer> intStack = new Stack<>();
        // Get the number of digits within the integer
        // x must be a positive integer to correctly determine the number of digits (can't log a negative number)
        int absoluteX = Math.abs(x);
        int numDigits = (int) Math.floor(Math.log10(absoluteX));
        for(int i = 0; i <= numDigits; i++)
        {
            intStack.push(x % 10);
            x /= 10;
        }

        System.out.println(intStack);

        // Reverse the stack
        Stack<Integer> reversedInts = new Stack<>();
        for(int i = 0; i <= numDigits; i++)
        {
            reversedInts.push(intStack.pop());
        }

        // Now we have a stack of integers, we can just pop from the stack and recombine into a stack
        long ret = 0;
        for(int i = numDigits; i >= 0; i--)
        {
            // Raise 10 to the ith power to multiply the digit (to get the correct pos)
            int mult = (int) Math.pow(10, i);
            ret += mult * reversedInts.pop();
        }

        if(ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE) return 0;

        return (int)ret;
    }
}
