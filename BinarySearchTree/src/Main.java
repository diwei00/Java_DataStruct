import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
class Student implements Comparable<Student>{
    public int age;
    public String name;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public int compareTo(Student o) {
        return this.age - o.age;
    }
}
public class Main {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(8);
        binarySearchTree.insert(5);
        binarySearchTree.insert(11);
        binarySearchTree.insert(25);
        binarySearchTree.insert(12);
        binarySearchTree.insert(7);
        binarySearchTree.insert(2);
        binarySearchTree.insert(9);
        binarySearchTree.insert(3);
        BinarySearchTree.TreeNode root = binarySearchTree.root;
        BinarySearchTree.TreeNode ret = binarySearchTree.Search(2);
        //System.out.println(ret.val);

        binarySearchTree.remove(2);
        binarySearchTree.inOrder(root);

    }
}
