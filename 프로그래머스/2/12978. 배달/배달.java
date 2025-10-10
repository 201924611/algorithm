import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class Node{
        int to;
        int weight;
        Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        // 다익스트라
        ArrayList<ArrayList<Node>> arr = new ArrayList<>();
        for(int i = 0; i<= N; i++){
            arr.add(new ArrayList<Node>());
        }

        for(int[] roa: road){
            arr.get(roa[0]).add(new Node(roa[1], roa[2]));
            arr.get(roa[1]).add(new Node(roa[0], roa[2]));
        }

        int [] diff = new int[N + 1];
        Arrays.fill(diff, Integer.MAX_VALUE);
        diff[1] = 0;
        PriorityQueue<Node> prior = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight)
        );
        prior.add(new Node(1, 0));
        while(!prior.isEmpty()){
            Node node = prior.poll();
            if(node.weight > diff[node.to] ){
                continue;
            }

            for(Node no : arr.get(node.to)){
                int newWeight = no.weight + diff[node.to];
                if(newWeight < diff[no.to] ){
                    diff[no.to] = newWeight;
                    prior.add(new Node(no.to, diff[no.to]));
                }
            }
        }
        for(int dif: diff){
            if( dif <= K){
                answer++;
            }
        }
        return answer;
    }
}