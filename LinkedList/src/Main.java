public class Main {
    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
        linkedList.createNode();
        linkedList.addFirst(8);
        linkedList.addFirst(2);
        linkedList.addEnd(25);
        try {
            linkedList.addIndexOf(2,95);
            linkedList.addIndexOf(5,99);
        } catch (IndexIllegalExpection e) {
            e.printStackTrace();
        }
        linkedList.remove(25);
        linkedList.removeAllKey(2);

        linkedList.clear();
        linkedList.display();
        System.out.println();
        System.out.println(linkedList.contains(257));
        System.out.println("大小：" + linkedList.size());

    }
}
