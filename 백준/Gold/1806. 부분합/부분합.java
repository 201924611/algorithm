import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//String str = "";
//str = br.readLine();
//StringTokenizer st = new StringTokenizer(br.readLine());
//String s = st.nextToken();

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        int sum =  Integer.parseInt(st.nextToken());

        int[] arr = new int[count];
        int temp = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        int left = 0;
        int right = 0;

        while(right <= count){
            if(temp >= sum) {
                if (answer > right - left || answer == 0) {
                    answer = right-left;
                }
                    temp -= arr[left];
                    left++;
            }else{
                if(right<count) {
                    temp += arr[right];
                    right++;
                }else{
                    right++;
                }
            }


            if(answer == 1){
                break;
            }
        }
        System.out.println(answer);

    }
}