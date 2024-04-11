package Problem2;

import java.util.ArrayList;

/**
 * General approach to the problem:
 * Convert l1 and l2 to integers using the function created
 * Add them together
 * Convert their digits to a LinkedList and return it as a result
 */



class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        // Do the addition
        int intOne = convertNodesToInt(l1);
        int intTwo = convertNodesToInt(l2);

        int sum = intOne + intTwo;

        ListNode curr = new ListNode();

        // Convert the sum into a node
        for(int i = 0; i <= (int) Math.log10(sum); i++)
        {
            // Start at the maximum digit and find the value of that digit

            curr.val = sum % (int) Math.pow(10, i + 1);
            curr.next = (i == (int) Math.log10(sum)) ? null : new ListNode(0);
        }
        
        return curr;
    }

    /**
     * Given a LinkedList of ints, converts to a single int.
     * @param n the list to convert.
     * @return a single int representation.
     */
    @SuppressWarnings("all")
    public int convertNodesToInt(ListNode n)
    {
        ArrayList<Integer> ints = new ArrayList<>();
        // The size of the list after the while loop will be stored here
        int count = 0;

        ListNode currNode = n;

        // Get all the nodes from the LinkedList and store them in an ArrayList, get the size of the list.
        while(currNode != null)
        {
            count++;
            ints.add(n.val);
            currNode = currNode.next;
        }

        int result = 0;
        int exponent = 0;

        for(int i = ints.size() - 1; i >= 0; i--)
        {
            int num = ints.get(i);
            // The amount to add to the quantity will be the digit multiplied by 10^n, where n is the position of the digit. On the first iteration, the digit is position 0 so 10^0 = 1, then 1, then 2...
            result += (Math.pow(num, exponent));

            exponent++;
        }

        return result;
    }
}
