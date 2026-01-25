class Solution {
    public int[] solution(int[] numbers) {
        // 길이가 최대 1000000이므로 for문 두번 반복하면 시간초과날듯
        // 따라서 최대 값을 순간순간 파악해가는 걸 하기
        // 순간 순간 최대 값 담을 곳
        // 처리 안된 인덱스  
        int num = 0;
        // -> 틀림 아직도오래걸림
        // 뒤에서부터 앞으로가면 빨리 될듯
        // 그리고 각 인덱스 위치를 저장할 배열
        int[] index = new int[numbers.length];
        for(int i = numbers.length - 1; i >=0 ;i-- ){
            int temp = numbers[i];
            if(num > numbers[i]){
                numbers[i] = num;
            }else{
                boolean state = false;
                for(int j = i+1; j < numbers.length; j++){
                    if( numbers[i] < numbers[j]){
                        numbers[i] = numbers[j];
                        state = true;
                        break;
                    }
                    if( numbers[j] == -1){
                        break;
                    }
                }
                if(!state){
                    numbers[i] = -1;
                }
            }
            num = temp;
            
        }
        return numbers;
    }
}