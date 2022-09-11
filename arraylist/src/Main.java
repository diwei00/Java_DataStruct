public class Main {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        try {
            arrayList.add(10,0);

            int ret = arrayList.indexOf(11);
            arrayList.remove(10);

            arrayList.set(0,10);
            int ret2 = arrayList.get(0);

            arrayList.display();

        }catch (EmptyExpection e) {
            e.printStackTrace();
        }catch (IndexExpection e) {
            e.printStackTrace();
        }

    }
}
