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
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[count];
        for(int i = 0; i<count; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dif = new int[count];
        int answer = 0;

        for(int i = 0; i < arr.length; i++){
            dif[i] = 1;
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j]){
                    dif[i] = Math.max(dif[i], dif[j]+1);
                }
            }
            answer = Math.max(answer, dif[i]);
        }

        System.out.println(answer);
    }
}