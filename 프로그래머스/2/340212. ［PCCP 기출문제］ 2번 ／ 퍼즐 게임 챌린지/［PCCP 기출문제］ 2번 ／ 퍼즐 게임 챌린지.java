class Solution {
    public static long level(int[] diffs, int[] times, int lv){
        long result = 0;
        for(int i = 0;i < diffs.length;i++){
            if(diffs[i] > lv) result += (long)(diffs[i] - lv) 
                * (long)(times[i - 1] + times[i]) + times[i];
            else result += (long)times[i];
        }
        return result;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int max = 1, min = 100000;
        while(max <= min){
            long mid = level(diffs, times, (max + min) / 2);
            if(mid > limit) max = (max + min) / 2 + 1;
            else min = (max + min) / 2 - 1;
        }
        return max;
    }
}