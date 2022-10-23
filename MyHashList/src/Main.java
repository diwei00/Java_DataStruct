public class Main {
    public static void main(String[] args) {
        MyHashList myHashList = new MyHashList();
        myHashList.put(5, 10);
        myHashList.put(6, 10);
        myHashList.put(7, 10);
        myHashList.put(9, 10);
        myHashList.put(10, 10);
        myHashList.put(8, 10);
        myHashList.put(7, 1);
        myHashList.put(12, 10);
        myHashList.put(15, 10);
        myHashList.put(10, 100);
        myHashList.put(80, 20);
        System.out.println(myHashList.get(10));
        System.out.println(myHashList.get(7));
        System.out.println(myHashList.get(5));
        System.out.println(myHashList.get(9));
        System.out.println(myHashList.get(80));
        System.out.println(myHashList.size());

    }
}
