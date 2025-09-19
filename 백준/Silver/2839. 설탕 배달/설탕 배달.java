import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//String str = "";
//str = br.readLine();
//StringTokenizer st = new StringTokenizer(br.readLine());
//String s = st.nextToken();

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int bef = num;
        int i = 0;
        int answer = 0;
        while(num > 0) {
            num = bef;
            num  -= (i * 3);
            answer = i;
            if ( answer < 0){
                break;
            }
            if (num >= 5) {
                answer += num / 5;
                num %= 5;
            }
            if (num >= 3) {
                answer += num / 3;
                num %= 3;
            }
            i++;
        }
        if(num == 0){
            System.out.println(answer);
        }else{
            System.out.println(-1);
        }
    }
}