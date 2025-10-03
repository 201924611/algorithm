import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int s = 0, e = distance, mid;
        while(s <= e) {
            mid = (s + e) /2;
            int cur = 0;
            int hits = 0;
            for(int i = 0; i < rocks.length; i++) {
                if(rocks[i] - cur < mid) {
                    hits++;
                }
                else {
                    cur = rocks[i];
                }
                if(i == rocks.length -1){
                    if(distance - cur < mid){
                        hits++;
                    }
                }
            }
            if(hits > n) {
                e = mid-1;
                
            }
            else {
                s = mid+1;
            }
        }
        answer = e;
        return answer;
    }
}