import java.util.*;
class Solution {
    Set<Integer> set;
    public int solution(int m, int n, int[][] puddles) {
        // 최단경로이므로 음의 경로로만 안움직이면 목적지까지 잘도착함
        int[][] graph = new int[n][m];
        set = new HashSet<>();
        for(int[] puddle: puddles){
            // 물에 잠긴지역인지 간단체크
            set.add(puddle[0] + puddle[1] - 2);
        }
        graph[0][0] = 1;
        fur(puddles, graph);
        return graph[n-1][m-1];
    }
    public void fur(int[][] puddles, int[][] graph){
        // 왼쪽값더하기 위쪽값
        
        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].length; j++){
                if(set.contains(i+j)){
                    if(!cont(puddles, j, i)) continue;
                }
                if(i + j == 0) continue;
                if(i == 0){
                    graph[i][j] = graph[i][j-1];
                }else if(j == 0){
                    graph[i][j] = graph[i-1][j];
                }else{
                    graph[i][j] = graph[i][j-1] + graph[i-1][j];
                }
                
                if(graph[i][j] > 1000000007){
                    graph[i][j] %= 1000000007;
                }
            }
        }
    }
    public boolean cont(int[][] puddles, int x, int y){
        for(int[] puddle : puddles){
            if(puddle[0]-1 == x && puddle[1] - 1 == y){
                return false;
            }
        }
        return true;
    }
}