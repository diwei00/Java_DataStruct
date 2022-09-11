import java.util.Arrays;

public class ArrayList {
    private int[] arr;
    private int usedSize;
    private static final int DEFAULT_SIZE = 10;
    public int getUsedSize() {
        return this.usedSize;
    }

    public ArrayList() {
        this.arr = new int[DEFAULT_SIZE];
    }
    public void add(int val) {

        //检测容量，不够则扩容
        if(getUsedSize() == arr.length) {
            arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }
        this.arr[usedSize] = val;
        this.usedSize++;
    }
    public void add(int val, int pos) throws IndexExpection{
        //检测pos位置是否合法
        if(pos < 0 || pos > getUsedSize()) {
            throw new IndexExpection("下标异常");
        }
        //检测容量
        if(getUsedSize() == arr.length) {
            this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);
        }

        for(int i = getUsedSize() - 1; i >= pos; i--) {
            this.arr[i + 1] = this.arr[i];
        }
        this.arr[pos] = val;
        this.usedSize++;

    }
    public int indexOf(int val) throws EmptyExpection{
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }

        for(int i = 0; i < getUsedSize(); i++) {
            if(this.arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
    public void remove(int val) throws EmptyExpection{
        //判空
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }
        int index = indexOf(val);
        if(index == -1) {
            System.out.println("没有这个数据");
            return;
        }
        for(int i = index; i < getUsedSize() - 1; i++) {
            this.arr[i] = this.arr[i + 1];
        }
        this.usedSize--;

    }
    public void clear() throws EmptyExpection{
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }
        this.usedSize = 0;
    }
    public Boolean contains(int val) throws EmptyExpection{
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }
        for(int i = 0; i < getUsedSize(); i++) {
            if(this.arr[i] == val) {
                return true;
            }
        }
        return false;
    }
    public void set(int pos, int val) throws IndexExpection, EmptyExpection{
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }
        if(pos < 0 || pos >= getUsedSize()) {
            throw new IndexExpection("下标异常");
        }
        this.arr[pos] = val;
    }
    public int get(int pos) throws IndexExpection, EmptyExpection{
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }
        if(pos < 0 || pos >= getUsedSize()) {
            throw new IndexExpection("下标异常");
        }
        return this.arr[pos];
    }
    public Boolean isEmpty() {
        return getUsedSize() == 0;
    }
    public void display() throws EmptyExpection{
        if(isEmpty()) {
            throw new EmptyExpection("空异常");
        }
        for(int i = 0; i < getUsedSize(); i++) {
            System.out.print(this.arr[i] + " ");
        }
    }
}
