import java.util.ArrayList;


class Solution {
    public ArrayList<Integer> solution(int[] arr) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for(int ar : arr){
            for(int i = 0; i < ar; i++){
                a.add(ar);
            }
        }
        return a;
    }
}