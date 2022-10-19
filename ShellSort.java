import java.util.Arrays;

public class ShellSort {
    private static void insertSort(int[] arr, int gap) {
        for(int i = gap; i < arr.length; i ++) {
            int tmp = arr[i];
            int j = i - gap;
            for( ; j >= 0; j -= gap) {
                if(tmp < arr[j]) {
                    arr[j + gap] = arr[j];
                }else {
                    //arr[j + 1] = tmp;
                    break;
                }
            }
            arr[j + gap] = tmp;
        }
    }

    /**
     * 希尔排序
     * 分组，设置gap，先预排序，当gap为1时就是直接插入排序
     * 时间复杂度： O(n^1.3) 没有确定具体值，每次按照最坏情况算，但是越排越接近有序
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int gap = arr.length;
        while(gap > 0) {
            gap /= 2;
            insertSort(arr, gap);

        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
