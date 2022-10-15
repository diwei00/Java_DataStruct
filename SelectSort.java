import java.util.Arrays;

public class SelectSort {
    /**
     * 选择排序  找最小的数据往前面放
     * 时间复杂度：等差数列 O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if(i != minIndex) {
                int tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    /**
     * 优化版
     * 同时找到最大和最小数据，往左右两边放
     * @param arr
     */

    public static void selectSort2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            int minIndex = left;
            int maxIndex = left;
            for(int i = left + 1; i <= right; i++) {
                if(arr[i] > arr[maxIndex]) {
                    maxIndex = i;
                }
                if(arr[i] < arr[minIndex]) {
                    minIndex = i;
                }
            }
            swap(arr, minIndex, left);
            //把最大的数据换走了，修正maxIndex
            if(maxIndex == left) {
                maxIndex = minIndex;
            }
            swap(arr, maxIndex, right);
            left++;
            right--;

        }
    }
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
