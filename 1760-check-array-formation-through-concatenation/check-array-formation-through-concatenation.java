class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        HashMap<Integer, int[]> map = new HashMap<>();
        for(int[] piece : pieces){
            map.put(piece[0], piece);
        }
        for(int i = 0; i < arr.length; i++){
            int[] piece = map.get(arr[i]);
            if(piece == null){
                return false;
            }
            for(int j = 0; j < piece.length; j++){
                if(arr[i + j] != piece[j]) {
                    return false;
                }
            }
            i += piece.length - 1;
        }
        return true;
    }
}