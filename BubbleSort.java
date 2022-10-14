import java.util.Arrays;

public class BubbleSort {
    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)  考虑优化，最好为O(n)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length - 1; i++) {
            //优化操作，数据本来就有序
            boolean flag = false;
            for(int j = 0; j < arr.length - 1 - i; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                    flag = true;
                }
                if(!flag) {
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
