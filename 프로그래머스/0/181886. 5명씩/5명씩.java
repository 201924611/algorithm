class Solution {
    public String[] solution(String[] names) {
        int count = 0;
        String str = "";
        for(String name : names){
            if(count % 5 == 0) str = str + name + ",";
            count++;
        }
        return str.split(",");
    }
}