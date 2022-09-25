public class MyQueue {
    static class ListNode {
        private int val;
        private ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    private int usedSize;
    private ListNode head;
    private ListNode tail;
    public void offer(int date) {
        ListNode newNode = new ListNode(date);
        if(head == null) {
            head = newNode;
            tail = newNode;
            this.usedSize++;
            return;
        }
        tail.next = newNode;
        tail = tail.next;
        this.usedSize++;

    }
    public int poll() {
        if(empty()) {
            throw new NullQueueExpection("空队列");
        }
        //只有一个节点特殊处理
        if(head.next == null) {
            int tmp = head.val;
            head = null;
            tail = null;
            this.usedSize--;
            return tmp;
        }
        int tmp = head.val;
        head = head.next;
        this.usedSize--;
        return tmp;
    }
    public int peek() {
        if(empty()) {
            throw new NullQueueExpection("空队列");
        }
        return this.head.val;
    }

    public int size() {
        return this.usedSize;
    }
    public boolean empty() {
        return this.usedSize == 0;
    }
}
