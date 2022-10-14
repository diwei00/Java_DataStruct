import java.util.Arrays;

public class myPriorityQueue {
    public int[] elem;
    private int usedSize;
    private static final int DEFAUTSIZE = 10;


    public myPriorityQueue(int[] arr) {
        elem = new int[DEFAUTSIZE];
        for(int i = 0; i < arr.length; i++) {
            elem[i] = arr[i];
            usedSize++;
        }
    }


    /**
     * 向下调整，建大堆
     * 时间复杂度：log(n)
     * @param parent
     * @param len
     */
    private void shiftDown(int parent, int len) {
        int child = parent * 2 + 1;
        while(child < len) {
            //确保有右孩子的存在，防止越界
            if(child + 1 < len && elem[child] < elem[child + 1]) {
                child++;
            }
            if(elem[child] > elem[parent]) {
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                //确保整棵树都是符合大堆要求
                parent = child;
                child = parent * 2 + 1;
            }else {
                break;
            }
        }
    }
    /**
     * 建堆，将每个元素向下调整
     * 时间复杂度 o(n)
     */
    public void createHeap() {
        //由下往上调整
        for(int parent = (usedSize - 1 - 1) / 2; parent >= 0; parent--) {
            shiftDown(parent, usedSize);
        }
    }

    /**
     * 向上调整，调孩子
     * @param child
     */
    private void shiftUp(int child) {
        int parent = (child - 1) / 2;
        while(child > 0) {
            if(elem[parent] < elem[child]) {
                int tmp = elem[parent];
                elem[parent] = elem[child];
                elem[child] = tmp;
                child = parent;
                parent = (child - 1) / 2;
            }else {
                break;
            }
        }
    }
    /**
     * 堆中插入，插入到最后面，向上调整，保持大堆
     * @param val
     */
    public void offer(int val) {
        //判断空间，不够则扩容
        if(isFull()) {
            this.elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[usedSize++] = val;

        shiftUp(usedSize - 1);
    }

    /**
     * 删除堆中元素，只能删除堆顶元素
     * 将堆顶和最后一个元素交换，删除最后一个，向下调整堆顶，保持大堆
     * @return
     */
    public int pop() {
        if(isEmpty()) {
            throw new NullArrayExpection("空数组");
        }
        int tmp = this.elem[0];
        this.elem[0] = this.elem[usedSize - 1];
        this.elem[usedSize - 1] = tmp;
        this.usedSize--;
        shiftDown(0, usedSize);
        return tmp;
    }
    public int peek() {
        if(isEmpty()) {
            throw new NullArrayExpection("空数组");
        }
        return this.elem[0];
    }
    public boolean isEmpty() {
        return usedSize == 0;
    }
    public boolean isFull() {
        return this.usedSize == this.elem.length;
    }
}
