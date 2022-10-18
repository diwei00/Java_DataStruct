import java.util.Arrays;

public class MargeSort {
    /**
     * 归并排序：
     * 时间复杂度：O(N*logN)
     * log(n)层，每层有n个数据
     * 空间复杂度：O(N)
     * 稳定性：稳定
     * 插入  冒泡  归并
     * @param
     */
    private static void marge(int[] arr, int begin, int mid, int end) {
        int len = end - begin + 1;
        int[] tmp = new int[len];
        int index = 0;
        int begin1 = begin;
        int end1 = mid;
        int begin2 = mid + 1;
        int end2 = end;
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
            arr[i + begin] = tmp[i];
        }
    }
    private static void margeSortChild(int[] arr, int begin, int end) {
        if(begin == end) {
            return;
        }
        int mid = (begin + end) >> 1;
        //递归左右区间，到一个数据，认为有序
        margeSortChild(arr, begin, mid);
        margeSortChild(arr, mid + 1, end);
        //合并
        marge(arr, begin, mid, end);
    }
    public static void margeSort(int[] arr) {
        margeSortChild(arr, 0, arr.length - 1);
    }
    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        margeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
