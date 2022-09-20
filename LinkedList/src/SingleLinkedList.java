public class SingleLinkedList {
    static class ListNode {
        private int val;
        private ListNode next;

        private ListNode(int val) {
            this.val = val;
        }

    }
    private ListNode head;
    //判断下一个节点的值，找上一个节点
    private ListNode findPrevNode(int key) {
        ListNode cur = head;
        while(cur.next != null) {
            if(cur.next.val == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;

    }
    //狗撵兔法找上一个节点
    private ListNode findPrevNode2(int key) {
        ListNode cur = head;
        ListNode prev = null;
        //限制cur，防止空指针异常
        while(cur != null && cur.val != key) {
            prev = cur;
            cur = cur.next;
        }
        if(cur == null) {
            return null;
        }
        return prev;
    }
    public void remove(int key) {
        if(this.head == null) {
            System.out.println("链表为空");
            return;
        }
        //删头节点
        if(this.head.val == key) {
            head = head.next;
            return;
        }

        ListNode prev = findPrevNode2(key);
        if(prev == null) {
            System.out.println("没有你要删除的数据");
            return;
        }
        prev.next = prev.next.next;
    }
    //前后指针遍历
    public void removeAllKey(int key) {
        ListNode prev = head;
        ListNode cur = head.next;
        while(cur != null) {
            if(cur.val == key) {
                prev.next = cur.next;
                cur = cur.next;
            }else {
                prev = cur;
                cur = cur.next;
            }
        }
        if(head.val == key) {
            head = head.next;
        }
    }
    public boolean contains(int key) {
        ListNode cur = this.head;
        while(cur != null) {
            if(cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void addIndexOf(int index, int date) throws IndexIllegalExpection{
        //首先判断index的合法性
        if(index < 0 || index > size()) {
            System.out.println("位置不合法");
            throw new IndexIllegalExpection("位置不合法");
        }
        if(index == 0) {
            addFirst(date);
        }
        if(index == size()) {
            addEnd(date);
        }

        ListNode cur = this.head;
        //找上一个节点
        while(index - 1 != 0) {
            cur = cur.next;
            index--;
        }
        ListNode newNode = new ListNode(date);
        newNode.next = cur.next;
        cur.next = newNode;
    }

    public void addEnd(int date) {
        ListNode newNode = new ListNode(date);
        ListNode cur = head;
        if(cur == null) {
            head = newNode;
            return;
        }
        //找尾
        while(cur.next != null) {
            cur = cur.next;
        }
        cur.next = newNode;


    }
    public void addFirst(int date) {
        ListNode newNode = new ListNode(date);
        newNode.next = this.head;
        this.head = newNode;
    }
    public void display() {
        ListNode cur = this.head;
        while(cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
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
    //没有引用则被jvm回收
    public void clear() {
        this.head = null;
    }
    public void createNode() {
        ListNode Node1 = new ListNode(1);
        ListNode Node2 = new ListNode(2);
        ListNode Node3 = new ListNode(3);
        ListNode Node4 = new ListNode(4);
        ListNode Node5 = new ListNode(5);
        this.head = Node1;
        Node1.next = Node2;
        Node2.next = Node3;
        Node3.next = Node4;
        Node4.next = Node5;
    }

}
