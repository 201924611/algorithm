class Solution {
    public long solution(int n, int[] times) {
        // times 이분탐색
        // 특정 시간까지 일햇을때
        // 입국 심사 기다리는 사람 다 처리할 수 있을때
        // 답이 long이니깐

        long min = 0;
        long max = Long.MAX_VALUE;
        long med = 0L;
        long answer = Long.MAX_VALUE;
        while(min <= max){
            med = (min + max)/2;
            long people = 0;
            for(int time: times){
                people += med / time;
                if(people >= n) break;
            }
            if(people >= n){
                answer = med;
                if(min == max){
                    break;
                }
                max = med;
            }else{
                min = med + 1;
            }


        }

        return answer;
    }
}