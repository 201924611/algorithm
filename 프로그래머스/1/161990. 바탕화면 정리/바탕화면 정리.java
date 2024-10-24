class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        int rdx = 0;
        int rdy = 0;
        int count = 0;
        for(String wall: wallpaper){
            for(int i =0; i < wall.length(); i++){
                if(wall.charAt(i) == '#'){
                    if(i < luy){
                        luy = i;
                    }
                    if(count < lux){
                        lux = count;
                    }
                    if(rdy < i){
                        rdy = i;
                    }
                    if(rdx < count){
                        rdx = count;
                    }
                }
            }
            count++;
        }
        return new int[]{lux, luy, rdx+1, rdy+1};
    }
}