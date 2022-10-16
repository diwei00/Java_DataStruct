//堆排序 排升序建大堆
//将堆顶元素换到最后面，其余元素保持大根堆，依次循环
import java.util.Arrays;

public class HeapSort {

    //向下调整时间复杂度：log(n)
    private static void shiftDown(int[] arr, int parent, int len) {
        int child = (parent * 2) + 1;
        while(child < len) {
            if(child + 1 < len && arr[child] < arr[child + 1]) {
                child++;
            }
            if(arr[parent] < arr[child]) {
                int tmp = arr[parent];
                arr[parent] = arr[child];
                arr[child] = tmp;
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }

    /**
     * 时间复杂度：
     * O(n) + O(n*logn) 约等于 O(nlogn)
     * 空间复杂度：O(1)
     * @param arr
     */
    public static void heapSort(int[] arr) {
        //建堆
        //时间复杂度：O(n) 错位相减法推导
        for(int i = (arr.length - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arr, i, arr.length);
        }
        //交换元素，建堆
        //时间复杂度：n * log(n)
        int end = arr.length - 1;
        while(end > 0) {
            int tmp = arr[end];
            arr[end] = arr[0];
            arr[0] = tmp;
            shiftDown(arr, 0, end);
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
