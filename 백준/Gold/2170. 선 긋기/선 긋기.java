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
        int[][] time = new int[count][2];
        for(int i = 0; i<count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j<2; j++){
                time[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        int answer = 0;
        int start = -1000000001;
        int end = -1000000001;
        for(int[] a: time){
            if( end < a[0]){
                answer += end - start;
                start = a[0];
                end = a[1];
            }else{
                if(end < a[1]){
                    end = a[1];
                }
            }
        }
        answer += end -start;
        System.out.println(answer);
    }
}