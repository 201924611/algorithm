class Solution {
    public int solution(int[] num_list) {
        int count = 0;
        int[] sum = new int[]{0, 0};
        for(int num: num_list){
            if(count % 2 == 0){
                sum[1] += num;
            }else{
                sum[0] += num; 
            }
            count++;
        }
        
        return (sum[0] > sum[1])? sum[0] : sum[1];
    }
}