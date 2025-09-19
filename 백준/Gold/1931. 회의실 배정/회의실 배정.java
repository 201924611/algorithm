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
        Arrays.sort(time,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]){
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        int answer = 0;
        int end = 0;
        for(int[] a: time){
            if(a[0] >= end){
                end = a[1];
                answer++;
            }
        }
        System.out.println(answer);
    }
}