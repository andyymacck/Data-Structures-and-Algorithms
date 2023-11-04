public class Node {
    int value;
    Node left;
    Node right;
    int height;

    Node(int value){
        this.value = value;
        this.height = 1;
    }
}
