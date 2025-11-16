import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {
        // b나라의 전략 아이기스 군사 기지
        // 폭격 요격
        // x축 겹치는 점찾기 최소한으로
        int answer = 0;
        // 시작점을 기준으로 정렬
        // 첫번쨰 좌표부터 시작점을 기준으로 최대한 겹치게 해서 배치

        Arrays.sort(targets, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        int max = targets[0][1];
        for(int[] target: targets){
            // max가 target의 최솟값보다 크면 한번에 처리가능
            if( target[0] < max){
                // target[1] 이 max보다 크면 상관없음
                // target[1] 이 max보다 작으면 target[1] 로 max를 바꿈
                if(target[1] < max){
                    max = target[1];
                }
            }else{
                // target의 최솟값이 max보다 크면 +1 하고 새로잡음
                answer++;
                max = target[1];
            }
        }
        answer++;
        return answer;
    }
}