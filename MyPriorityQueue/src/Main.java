import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {27,15,19,18,28,34,65,49,25,37};
        myPriorityQueue createHeap = new myPriorityQueue(arr);
        createHeap.createHeap();
        createHeap.offer(60);
        System.out.println(Arrays.toString(createHeap.elem));
        System.out.println(createHeap.pop());
        System.out.println(Arrays.toString(createHeap.elem));
        System.out.println(createHeap.pop());
        System.out.println(Arrays.toString(createHeap.elem));

    }
}
