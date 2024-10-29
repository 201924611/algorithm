class Solution {
    public int solution(int[] num_list) {
        int multi = 1;
        int sumSqrt = 0;
        for(int num : num_list){
            multi *= num;
            sumSqrt += num;
        }
        sumSqrt = (int)Math.pow(sumSqrt, 2);
        
        return multi < sumSqrt? 1: 0;
    }
}