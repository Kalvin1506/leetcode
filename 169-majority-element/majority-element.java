class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> res = new HashMap<>();
        for(int i :nums){
            res.put(i, res.getOrDefault(i,0)+1);
        }
        int highestKey = res.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(-1);
        
        return highestKey;
    }
}