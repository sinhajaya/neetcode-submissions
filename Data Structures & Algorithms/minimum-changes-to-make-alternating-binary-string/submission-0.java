class Solution {
    public int minOperations(String s) {
        int n = s.length();
        int changeOfPatterns0 = 0;

        for(int i=0;i<n;i++){
            char expected = (i % 2==0) ? '0' : '1';

            if(s.charAt(i) != expected){
                changeOfPatterns0++;
            }
        }
        return Math.min(changeOfPatterns0, n-changeOfPatterns0);
    }
}