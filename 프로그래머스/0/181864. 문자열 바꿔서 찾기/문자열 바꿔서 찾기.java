class Solution {
    public int solution(String myString, String pat) {
        String a = myString.replaceAll("A", "C");
        String b = a.replaceAll("B", "A");
        String c = b.replaceAll("C", "B");
        
        if(c.contains(pat)){
            return 1;
        }else{
            return 0;
        }
    }
}