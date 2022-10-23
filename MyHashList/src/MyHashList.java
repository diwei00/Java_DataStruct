import java.util.Arrays;
import java.util.HashMap;
//两个对象一样，它们的哈希值一定一样
//两个哈希值一样，对象不一定一样

public class MyHashList {
    static class Node {
        public int key;
        public int val;
        public Node next;
        public Node(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
    private static final int DEFAULTSIZE = 10;
    private Node[] arr;
    private int size;
    public MyHashList() {
        arr = new Node[DEFAULTSIZE];
        this.size = 0;
    }
    //扩容后，数组长度会改变，原来的值需重新Hash
    private void addCapicity() {
        Node[] tmp = new Node[arr.length * 2];
        for(int i = 0; i < this.arr.length; i++) {
            Node cur = arr[i];
            //直接将cur拿起，插入到新位置
            while(cur != null) {
                Node curNext = cur.next;
                int index = cur.key % tmp.length;
                //头插法
                cur.next = tmp[index];
                tmp[index] = cur;
                cur = curNext;
            }
        }
        this.arr = tmp;

    }
    public int put(int key, int val) {
        //遍历哈希表如果有相同key则替换其val
        for(int i = 0; i < this.arr.length; i++) {
            Node cur = arr[i];
            while(cur != null) {
                if(cur.key == key) {
                    cur.val = val;
                    return val;
                }
                cur = cur.next;
            }
        }
        //采用头插法
        //哈希值通过哈希函数计算其下表
        int index = key % arr.length;
        Node newNode = new Node(key, val);
        newNode.next = this.arr[index];
        this.arr[index] = newNode;
        this.size++;

        //负载因子大于0.75，冲突率会大，需扩容
        float ret = size * 1.0f / arr.length;
        if(ret >= 0.75) {
            addCapicity();
        }
        return val;
    }
    public int get(int key) {
        //对象，会有自己对应的哈希码
        //根据哈希码可计算出对应的哈希值
        int index = key % arr.length;
        Node cur = arr[index];
        while(cur != null) {
            if(cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }
    public int size() {
        return this.size;
    }
}
