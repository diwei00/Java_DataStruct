public class MyLinkedList {
    static class ListNode {
        private int val;
        private ListNode prev;
        private ListNode next;
        public ListNode(int val) {
            this.val = val;
        }
    }
    ListNode head;
    ListNode tail;
    public void addFirst(int date) {
        ListNode newNode = new ListNode(date);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = head.prev;
    }
    public void addLast(int date) {
        ListNode newNode = new ListNode(date);
        if(head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = tail.next;
    }
    private ListNode findNode(int index) {
        ListNode cur = head;
        while(index-- != 0) {
            cur = cur.next;
        }
        return cur;
    }
    public void addIndexOf(int index, int date) throws IndexIllegExpection{
        if(index < 0 || index > size()) {
            throw new IndexIllegExpection("下标非法");
        }
        if(index == 0) {
            addFirst(date);
            return;
        }
        if(index == size()) {
            addLast(date);
            return;
        }
        ListNode newNode = new ListNode(date);
        ListNode cur = findNode(index);
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
    }
    public void removeFirst() {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }
    public void removeLast() {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        if(head.next == null) {
            head = null;
            tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }
    private ListNode findNodeOfKey(int key) {
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public void remove(int key) {
        ListNode cur = findNodeOfKey(key);
        if(cur == null) {
            System.out.println("没有你要删除的元素");
            return;
        }
        if(cur == head) {
            removeFirst();
            return;
        }
        if(cur == tail) {
            removeLast();
            return;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;

    }
    public void removeAllKey(int key) {

        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        //哨兵位节点
        ListNode sentry = new ListNode(-1);
        sentry.next = head;
        head.prev = sentry;
        ListNode cur = sentry;
        while(cur != null) {

            if(cur.val == key) {
                //尾节点特殊处理
                if(cur == tail) {
                    tail = tail.prev;
                    tail.next = null;
                    break;
                }
                cur.next.prev = cur.prev;
                cur.prev.next = cur.next;
            }
            cur = cur.next;
        }
        if(sentry.next == null) {
            head = null;
            tail = null;
            return;
        }
        //修改头节点
        head = sentry.next;
        if(head != null) {
            head.prev = null;
        }
    }
    public void clear() {
        if(head == null) {
            System.out.println("链表为空");
            return;
        }
        ListNode cur = head;
        ListNode curNext = head.next;
        while(cur != null) {
            cur.next = null;
            cur.prev = null;
            cur = curNext;
            if(curNext != null) {
                curNext = curNext.next;
            }
        }
        head = null;
        tail = null;
    }
    public boolean contains(int key) {
        ListNode cur = head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public int size() {
        int count = 0;
        ListNode cur = this.head;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;

    }
    public void display() {
        ListNode cur = head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }
}
