class Solution {
    int[][] dp;
    public int solution(String[] arr) {
        dp = new int[arr.length][arr.length];
        for(int i = 0; i<dp.length; i++){
            for(int j = 0; j<dp[i].length;j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
            if(i % 2 == 0) dp[i][i] = Integer.parseInt(arr[i]);
        }
        int answer = solve(arr, 0, arr.length-1);
        return answer;
    }

    int solve(String[] arr, int a, int b){
        if(dp[a][b] != Integer.MAX_VALUE) {
            return dp[a][b];
        }
        

        // 왼쪽이 음수일떄
        if( a-1>0 && arr[a-1].equals("-")){
            // 최솟값 나오게
            int num = Integer.MAX_VALUE;
            for(int i = a; i < b; i+=2){
                if(arr[i+1].equals("+")) { // 오른쪽 양수일떄
                    num = Math.min(num, solve(arr, a, i) + solve(arr, i+2, b));
                }else{
                    num = Math.min(num, solve(arr, a, i) - solve(arr, i+2, b));
                }
            }
            dp[a][b] = num;
        }else{
            // 왼쪽이 양수일때
            // 최대값 나오게
            int num = Integer.MIN_VALUE;
            for(int i = a; i < b; i+=2){
                if(arr[i+1].equals("+")) { // 오른쪽 양수일떄
                    num = Math.max(num, solve(arr, a, i) + solve(arr, i+2, b));
                }else{
                    num = Math.max(num, solve(arr, a, i) - solve(arr, i+2, b));
                }
            }
            dp[a][b] = num;
        }
        return  dp[a][b];
    }
}