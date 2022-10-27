import java.util.Arrays;
import java.util.Stack;
//快排非递归
public class QuickSort2 {
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    private static int findPivot(int[] arr, int begin, int end) {

        int pivot = arr[begin];
        while(begin < end) {
            while(begin < end && arr[end] >= pivot) {
                end--;
            }
            swap(arr, end, begin);
            while(begin < end && arr[begin] <= pivot) {
                begin++;
            }
            swap(arr, begin, end);
        }
        arr[begin] = pivot;
        return begin;
    }
    public static void quickSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        int begin = 0;
        int end = arr.length - 1;
        int pivot = findPivot(arr, begin, end);
        if(pivot - 1 > begin) {
            stack.push(begin);
            stack.push(pivot - 1);
        }
        if(end > pivot + 1) {
            stack.push(pivot + 1);
            stack.push(end);
        }
        while (!stack.isEmpty()) {
            end = stack.pop();
            begin = stack.pop();
            pivot = findPivot(arr, begin, end);
            if(pivot - 1 > begin) {
                stack.push(begin);
                stack.push(pivot - 1);
            }
            if(end > pivot + 1) {
                stack.push(pivot + 1);
                stack.push(end);
            }

        }
    }

    /**
     * 利用栈模拟递归的过程
     * 区间内剩余一个元素就不用入栈，认为有序
     * 出栈，确定区间，找到基准，分别入左右区间
     * @param arr
     */
    public static void quickSort2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int begin = 0;
        int end = arr.length - 1;
        if(end > begin) {
            stack.push(begin);
            stack.push(end);
        }
        while(!stack.isEmpty()) {
            end = stack.pop();
            begin = stack.pop();
            int pivot = findPivot(arr, begin, end);
            if(pivot - 1 > begin) {
                stack.push(begin);
                stack.push(pivot - 1);
            }
            if(end > pivot + 1) {
                stack.push(pivot + 1);
                stack.push(end);
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        quickSort2(arr);
        System.out.println(Arrays.toString(arr));

    }
}
