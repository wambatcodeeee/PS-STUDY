import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static long count = 0;

    static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    static void merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while(i <= mid && j <= right){
            if(array[i] <= array[j]){
                temp[k++] = array[i++];
            }else{
                temp[k++] = array[j++];
                count += mid - i + 1;
            }
        }
        
        while(i <= mid){
            temp[k++] = array[i++];
        }
        
        while(j <= right){
            temp[k++] = array[j++];
        }
        
        for(i = left; i <= right; i++){
            array[i] = temp[i - left];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        mergeSort(arr, 0, N - 1);
        
        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}