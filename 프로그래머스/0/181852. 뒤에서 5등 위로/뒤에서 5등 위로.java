import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] arr = new int[num_list.length - 5];
        Arrays.sort(num_list);
        System.arraycopy(num_list, 5, arr, 0, num_list.length-5);
        return arr;
    }
}