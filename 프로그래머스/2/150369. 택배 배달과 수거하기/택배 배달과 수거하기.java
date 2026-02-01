import java.util.*;
class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        // cap 만큼 가지고 갈때 몇 번째 인덱스 까지 가는지 기록
        int deliveriesIndex = deliveries.length -1;
        int pickupsIndex = pickups.length - 1;
        while(true){
            int deliveriesTemp = -1;
            int pickupsTemp = -1;
            int deliveriesSum = 0;
            int pickupsSum = 0;
            // 배달 처리 부분
            while (deliveriesIndex >= 0 && deliveriesSum < cap) {
                // 1. 현재 인덱스에 배달할 물량이 없는 경우, 물량이 있는 곳까지 인덱스 이동
                if (deliveries[deliveriesIndex] == 0) {
                    deliveriesIndex--;
                    continue;
                }

                // 2. 이번 왕복에서 가장 멀리 가는 지점 기록 (처음 물량을 발견했을 때)
                if (deliveriesSum == 0) {
                    deliveriesTemp = deliveriesIndex;
                }

                // 3. 물량 처리
                int canDeliver = cap - deliveriesSum; // 현재 트럭에 실을 수 있는 여유 공간
                if (deliveries[deliveriesIndex] > canDeliver) {
                    // 현재 집 물량이 여유 공간보다 많으면, 여유분만큼만 배달하고 중단
                    deliveries[deliveriesIndex] -= canDeliver;
                    deliveriesSum = cap;
                    // 다음 턴에 이 집부터 다시 확인해야 하므로 break
                    break;
                } else {
                    // 현재 집 물량을 다 배달할 수 있는 경우
                    deliveriesSum += deliveries[deliveriesIndex];
                    deliveries[deliveriesIndex] = 0;
                    deliveriesIndex--; // 다음 집으로 이동
                }
            }
            // 수거 처리 부분
            while (pickupsIndex >= 0 && pickupsSum < cap) {
                // 1. 현재 인덱스에 수거할 물량이 없는 경우 이동
                if (pickups[pickupsIndex] == 0) {
                    pickupsIndex--;
                    continue;
                }

                // 2. 이번 왕복에서 가장 멀리 가는 지점 기록
                if (pickupsSum == 0) {
                    pickupsTemp = pickupsIndex;
                }

                // 3. 물량 처리
                int canPickup = cap - pickupsSum;
                if (pickups[pickupsIndex] > canPickup) {
                    pickups[pickupsIndex] -= canPickup;
                    pickupsSum = cap;
                    break;
                } else {
                    pickupsSum += pickups[pickupsIndex];
                    pickups[pickupsIndex] = 0;
                    pickupsIndex--;
                }
            }
            answer += 2 * ((long) Math.max(deliveriesTemp, pickupsTemp) + 1L);
            if(deliveriesIndex == -1 && pickupsIndex == -1){
                break;
            }
        }

        return answer;
    }
}