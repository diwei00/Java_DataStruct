public class Main {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        linkedList.addIndexOf(2, 88);
        linkedList.addIndexOf(0,99);
        linkedList.addIndexOf(7,100);
        linkedList.removeFirst();
        linkedList.removeLast();
        linkedList.remove(88);
        linkedList.remove(1);
        linkedList.remove(5);

        linkedList.clear();
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.addLast(1);
        linkedList.removeAllKey(1);
        linkedList.addLast(2);
        linkedList.addLast(2);
        linkedList.addLast(2);
        linkedList.addLast(2);
        linkedList.addLast(2);

        linkedList.display();
        System.out.println();
        System.out.println(linkedList.contains(50));
        System.out.println("大小：" + linkedList.size());
    }
}
