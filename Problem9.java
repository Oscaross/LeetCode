class Solution {
    public boolean isPalindrome(int x) {
        Integer xx = x;
        String intAsString = xx.toString();
        char[] stringAsArr = new char[intAsString.length()];
        // Copy string to an array of chars
        for(int i = 0; i < intAsString.length(); i ++) {
            stringAsArr[i] = intAsString.charAt(i);
        }

        System.out.println(stringAsArr.length);

        // Check whether the value at index 0 = i and so on until we reach the      middle element

        int i = 0;
        int j = stringAsArr.length - 1;
        while(i < stringAsArr.length / 2) {
            if(stringAsArr[i] != stringAsArr[j]) return false;

            i++;
            j--;
        }

        return true;
    }
}
