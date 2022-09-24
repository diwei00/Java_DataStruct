import java.util.Arrays;

public class Mystack {

    private static final int DEFAULT_SIZE = 10;
    private int[] elem;
    private int top;
    public Mystack() {
        elem = new int[DEFAULT_SIZE];
    }
    //压栈
    public int push(int val) {
        if(size() == elem.length) {
            this.elem = Arrays.copyOf(elem, elem.length * 2);
        }
        this.elem[top] = val;
        this.top++;
        return val;
    }
    public int pop() {
        if(empty()) {
            throw new NullStackExpection("栈为空");
        }
        return this.elem[--top];
    }
    public int peek() {
        if(empty()) {
            throw new NullStackExpection("栈为空");
        }
        return this.elem[top - 1];
    }
    public int size() {
        return this.top;
    }
    public boolean empty() {
        return size() == 0;
    }
}
