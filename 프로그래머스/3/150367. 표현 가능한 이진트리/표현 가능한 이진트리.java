import java.util.*;

class Solution {

    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String str = Long.toBinaryString(numbers[i]);

            int len = str.length();
            int size = 1;
            while (size - 1 < len) size <<= 1;

            str = "0".repeat((size - 1) - len) + str;

            answer[i] = isValid(str, 0, str.length() - 1) ? 1 : 0;
        }
        return answer;
    }

    private boolean isValid(String str, int left, int right) {
        if (left > right) return true;

        int mid = (left + right) / 2;

        if (str.charAt(mid) == '0') {
            // 부모가 0이면, 이 구간에 1이 있으면 안 됨
            for (int i = left; i <= right; i++) {
                if (str.charAt(i) == '1') return false;
            }
            return true;
        }

        // 부모가 1이면 자식 검사
        return isValid(str, left, mid - 1)
            && isValid(str, mid + 1, right);
    }
}
