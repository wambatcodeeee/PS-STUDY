import java.util.*;

class Solution {
    public int[] solution(String[] wallpaper) {
        int height = wallpaper.length;
        int width = wallpaper[0].length();
        int lux = Integer.MAX_VALUE, luy = Integer.MAX_VALUE, 
        rdx = Integer.MIN_VALUE, rdy = Integer.MIN_VALUE;
        
        for(int i = 0;i < height;i++){
            for(int j = 0;j < width;j++){
                if(wallpaper[i].charAt(j) == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i + 1);
                    rdy = Math.max(rdy, j + 1);
                }
            }
        }
        
        int[] answer = {lux, luy, rdx, rdy};
        
        return answer;
    }
}