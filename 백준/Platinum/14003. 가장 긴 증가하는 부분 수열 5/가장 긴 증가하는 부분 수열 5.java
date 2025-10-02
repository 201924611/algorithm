    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.*;

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
            // LIS 라는 배열 선언하고
            // arr에 담긴 배열 순차적으로 LIS 에 옮기는 과정
            // LIS에 이진탐색적용하여 현재 값이 어디 인덱스에 들어갈지 찾기
            int[] arr = new int[count];
            int[] temp = new int[count];
            for(int i = 0; i<count; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            int[] lis = new int[count];
            int index = 0;
            for(int i = 0; i < arr.length; i++){
                int search = Arrays.binarySearch(lis, 0, index, arr[i]);
                if(search < 0){
                    search = -(search + 1);
                }
                lis[search] = arr[i];
                temp[i] = search + 1;
                if(search == index){
                    index++;
                }
            }
            System.out.println(index);
            List<Integer> answer = new ArrayList<>();
            for(int i = count-1; i>=0; i--){
                if(temp[i] == index){
                    answer.add(arr[i]);
                    index--;
                }
            }
            for(int i = answer.size() -1; i>=0; i--){
                System.out.print(answer.get(i) + " ");
            }
        }
    }