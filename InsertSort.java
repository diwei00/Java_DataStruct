//直接插入排序，类似扑克牌玩法
//
import java.util.Arrays;

public class InsertSort {
    /**
     * 时间复杂度：
     * 最坏情况下：什么情况下最坏？逆序：O(N^2)
     * 最好情况下：什么情况下是最好情况？ 有序：O(n)
     * 得出一个结论：当数据量不多，且基本上趋于有序的时候，直接插入排序是非常快的！
     * 空间复杂度：  O(1)
     * 稳定性： 稳定
     *  一个本身就稳定的排序，可以实现为不稳定的排序
     *  但是一个本身就不稳定的排序 能实现为稳定的排序吗？？
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i - 1;
            for(; j >= 0; j--) {
                if(tmp < arr[j]) {
                    arr[j + 1] = arr[j];
                }else {
                    //arr[j + 1] = tmp;
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
