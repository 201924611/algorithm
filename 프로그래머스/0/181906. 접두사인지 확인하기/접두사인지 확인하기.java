class Solution {
    public int solution(String my_string, String is_prefix) {
        return my_string.substring(0, my_string.length() > is_prefix.length()? is_prefix.length(): 0).equals(is_prefix)? 1 : 0;
    }
}