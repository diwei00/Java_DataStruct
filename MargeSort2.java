import java.util.Arrays;

public class MargeSort2 {
    private static void marge(int[] arr, int left, int mid, int right) {
        int begin1 = left;
        int end1 = mid;
        int begin2 = mid + 1;
        int end2 = right;
        int[] tmp = new int[right - left + 1];
        int index = 0;
        while(begin1 <= end1 && begin2 <= end2) {
            if(arr[begin1] <= arr[begin2]) {
                tmp[index++] = arr[begin1++];
            }else {
                tmp[index++] = arr[begin2++];
            }
        }
        while(begin1 <= end1) {
            tmp[index++] = arr[begin1++];
        }
        while(begin2 <= end2) {
            tmp[index++] = arr[begin2++];
        }
        for(int i = 0; i < index; i++) {
            arr[i + left] = tmp[i];
        }
    }
    /**
     * 一个一个有序，两个两个有序，四个四个有序
     * @param arr
     */
    public static void margeSort(int[] arr) {
        int gap = 1;
        while(gap < arr.length) {
            //一组内有两个gap
            for(int i = 0; i < arr.length; i += gap * 2) {
                int left = i;
                int mid = left + gap - 1;
                int right = mid + gap;
                //可能越界，修正到最后面
                if(mid > arr.length - 1) {
                    mid = arr.length - 1;
                }
                if(right > arr.length - 1) {
                    right = arr.length - 1;
                }
                marge(arr, left, mid, right);
            }
            gap *= 2;
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        margeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
