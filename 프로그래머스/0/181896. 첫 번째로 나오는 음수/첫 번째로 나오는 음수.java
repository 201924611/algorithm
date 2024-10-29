class Solution {
    public int solution(int[] num_list) {
        int count = 0;
        for(int num: num_list){
            if(num < 0){
                return count;
            }
            count++;
        }
        return -1;
    }
}