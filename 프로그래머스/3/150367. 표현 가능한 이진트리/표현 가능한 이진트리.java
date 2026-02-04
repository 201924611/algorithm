import java.util.*;
class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        // 1. 수를 이진수로 표현하고 배열에 넣을 떄 루트 노드가 존재하면서 이진트리가 되면 성공
        // 2. 문자열은 2제곱 - 1만큼의 크기가 되어야함
        for(int i = 0; i<numbers.length; i++){
            String str = Long.toBinaryString(numbers[i]);
            // 크기 구하기
            int len = str.length();
            int size = 1;
            while (size - 1 < len) {
                size *= 2;
            }
            str = "0".repeat((size - 1) - len) + str;
            // 이진트리 되는지 체크용
            boolean state = false;
            int min = 0;
            int max = size - 2;
            int med = (min + max) /2;
            if(str.charAt(med) == '0'){
                continue;
            }
            // 루트
            Queue<Integer> que = new LinkedList<>();
            que.add(min);
            que.add(max);
            while(!que.isEmpty()){
                int tempMin = que.poll();
                int tempMax = que.poll();
                int tempMed = (tempMin + tempMax) /2;
                if( str.charAt(tempMed) == '1' ) {
                    if(tempMin < tempMed - 1){
                        que.add(tempMin);
                        que.add(tempMed-1);
                    }
                    if(tempMax > tempMed + 1){
                        que.add(tempMed + 1);
                        que.add(tempMax);
                    }
                }else{
                    for(int j = tempMin; j<= tempMax; j++){
                        if( str.charAt(j) == '1') state = true;
                        if(state) break;
                    }
                    if(state) break;
                }
            }
            if(state) answer[i] = 0;
            else answer[i] = 1;
        }
        return answer;
    }
}