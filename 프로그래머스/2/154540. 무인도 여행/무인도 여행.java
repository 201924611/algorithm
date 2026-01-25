import java.util.*;
class Solution {
    int[] dx = {0, 1, 0, -1};
    int[] dy = {1, 0, -1, 0};
    public int[] solution(String[] maps) {

        // 방문 체크용 state
        boolean[][] state = new boolean[maps.length][maps[0].length()];
        
        // 담을 공간
        List<Integer> list = new ArrayList<>();
        // bfs용 큐
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[i].length(); j++){
                if(maps[i].charAt(j) != 'X' && !state[i][j]){
                    que.add(i);
                    que.add(j);
                    int num = Integer.valueOf(maps[i].charAt(j)) -48;
                    while(!que.isEmpty()){
                        int row = que.poll();
                        int column = que.poll();
                        state[row][column] = true;
                        for(int k = 0; k< 4; k++){
                            int tempRow = row + dx[k];
                            int tempColumn = column + dy[k];
                            if(tempRow >= 0 && tempRow < maps.length 
                               && tempColumn >= 0 && tempColumn < maps[0].length()
                              && !state[tempRow][tempColumn] && maps[tempRow].charAt(tempColumn) != 'X'){
                                state[tempRow][tempColumn] = true;
                                que.add(tempRow);
                                que.add(tempColumn);
                                num += Integer.valueOf(maps[tempRow].charAt(tempColumn)) - 48;
                            }
                        }
                    }
                    list.add(num);
                } 
            }
        }
        Collections.sort(list);
        // 초 간단 bfs 문제
        int[] answer;
        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            answer = new int[list.size()];
        }
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}