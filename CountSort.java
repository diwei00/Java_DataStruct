import java.util.Arrays;

public class CountSort {
    /**
     * 计数排序：范围小 且集中的数据
     * 时间复杂度：O(n+范围) -》 范围越小，时间复杂度越小
     * 空间复杂度：O(范围)
     * @param arr
     */
    public static void countSort(int[] arr) {
        int index = 0;
        int min = arr[0];
        int max = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        int[] tmp = new int[max - min + 1];
        for(int i = 0; i < arr.length; i++) {
            tmp[arr[i] - min]++;
        }
        //O(n + 范围)
        for(int i = 0; i < tmp.length; i++) {
            while(tmp[i] != 0) {
                arr[index++] = i + min;
                tmp[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
