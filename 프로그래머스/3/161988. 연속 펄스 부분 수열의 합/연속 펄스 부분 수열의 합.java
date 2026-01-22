import java.util.Arrays;
class Solution {
    public long solution(int[] sequence) {
        // dp
        // 누적합
        long answer = 0;
        long[] minusStart = new long[sequence.length];
        long[] plusStart = new long[sequence.length];
        
        int[] num = {-1, 1};
        minusStart[0] = -1 * sequence[0];
        long maxMinus = minusStart[0];
        int maxMinusIndex = 0;
        int minMinusIndex = 0;
        long minMinus = minusStart[0];
        plusStart[0] = sequence[0];
        long maxPlus = plusStart[0];
        int maxPlusIndex = 0;
        int minPlusIndex = 0;
        long minPlus = plusStart[0];
        for(int i = 1; i<sequence.length; i++){
            minusStart[i] = minusStart[i-1] + sequence[i] * num[i%2];
            if(maxMinus < minusStart[i]){
                maxMinus = minusStart[i];
                maxMinusIndex = i;
            }
            if(minMinus > minusStart[i]){
                minMinus = minusStart[i];
                minMinusIndex = i;
            }
            
            plusStart[i] = plusStart[i-1] + sequence[i] * num[(i+1) % 2];
            if(maxPlus < plusStart[i]){
                maxPlus = plusStart[i];
                maxPlusIndex = i;
            }
            if(minPlus > plusStart[i]){
                minPlus = plusStart[i];
                minPlusIndex = i;
            }
        }
        long answerMinus = 0;
        long answerPlus = 0;
        if(minMinusIndex < maxMinusIndex){
            answerMinus = Math.max(maxMinus - minMinus, maxMinus);
        }else{
            long tempMax = minMinus;
            long tempMin = Long.MAX_VALUE;
            for(int i = 0; i<=maxMinusIndex; i++){
                if(tempMin > minusStart[i]){
                    tempMin = minusStart[i];
                }
            }
                
            for(int i = minMinusIndex + 1; i<minusStart.length; i++){
                if(tempMax < minusStart[i]){
                    tempMax = minusStart[i];
                }
            }
            answerMinus = Math.max(Math.max(maxMinus - tempMin, maxMinus), tempMax - minMinus);
        }
        
        if(minPlusIndex < maxPlusIndex){
            answerPlus = Math.max(maxPlus-minPlus, maxPlus);
        }else{
            long tempMax = minPlus;
            long tempMin = Long.MAX_VALUE;
            for(int i = 0; i<=maxPlusIndex; i++){
                if(tempMin > plusStart[i]){
                    tempMin = plusStart[i];
                }
            }
                
            for(int i = minPlusIndex + 1; i<plusStart.length; i++){
                if(tempMax < plusStart[i]){
                    tempMax = plusStart[i];
                }
            }
            answerPlus = Math.max(Math.max(maxPlus - tempMin, maxPlus), tempMax - minPlus);
        }  
        
        answer = Math.max(answerMinus, answerPlus);
        return answer;
    }
}