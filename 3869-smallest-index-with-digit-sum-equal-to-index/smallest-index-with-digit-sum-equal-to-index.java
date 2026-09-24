class Solution {
    public int findsum(int nu){
        int temp=nu;
        int sum=0;
        while(temp>0){
            int rem=temp%10;
            sum+=rem;
            temp=temp/10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i =0;i<nums.length;i++){
            int su = findsum(nums[i]);
            if(i==su){
                return i;
            }
        }
        return -1;
        
    }
}