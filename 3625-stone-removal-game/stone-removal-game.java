class Solution {
    public boolean canAliceWin(int n) {
        int alice = 10;
        int count =0;
        while(n>=alice){
            n = n-alice;
            alice--;
            count++;
        }
        if(count%2!=0){
            return true;
        }
        return false;
    }
}