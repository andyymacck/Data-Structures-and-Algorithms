
public class Main {
    public static void main(String[] args) {
        //question 1 test
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);

        //left part of tree
        root.left = node2;
        node2.parent = root;

        node2.left = node4;
        node4.parent = node2;

        node2.right = node5;
        node5.parent = node2;

        //right part of tree
        root.right = node3;
        node3.parent = root;

        node3.left = node6;
        node6.parent = node3;

        node3.right = node7;
        node7.parent = node3;

        System.out.println(preOrderNext(node5));
        System.out.println(preOrderNext(node7));
        System.out.println(postOrderNext(node5));
        System.out.println(postOrderNext(node6));

        //question 2 test

        System.out.println(isBinarySearchTree(root));

        //binary search tree

        Node root2 = new Node(4);

        root2.left = new Node(2);
        root.left.parent = root2;

        root2.right = new Node(6);
        root2.right.parent = root2;

        root2.left.left = new Node(1);
        root2.left.left.parent = root2.left;

        root2.left.right = new Node(3);
        root2.left.right.parent = root2.left;

        root2.right.left = new Node(5);
        root2.right.left.parent = root2.right;

        root2.right.right = new Node(7);
        root2.right.right.parent = root2.right;
        System.out.println(isBinarySearchTree(root2));

        //question 4 test

        HashTable Table = new HashTable(10);
        int[] elements = {1, 5, 21, 26, 39, 14, 15, 16, 17, 18, 19, 20, 111, 145, 146};

        for(int e:elements){
            Table.insert(e);
        }
            Table.display();
        //question 5 test
        node5.preOrderNumber();
        System.out.println(node5.preOrder);
        node5.postOrderNumber();
        System.out.println(node5.postOrder);
        node5.inOrderNumber();
        System.out.println(node5.inOrder);
    }
    //question 1
    public static Node preOrderNext(Node x){
       if(x.left != null){
           return x.left;
       }
       if(x.right != null){
           return x.right;
       }
       while(x.parent != null){
           if(x.parent.right != null && x != x.parent.right){
               return x.parent.right;
           }else{
               x = x.parent;
           }
       }
        System.out.println("There is no next node");
       return null;
    }

    public static Node postOrderNext(Node x){
        if(x.parent == null){
            return null;
        }
        if(x == x.parent.right ||  x.parent.right == null){
            return x.parent;
        }
       Node nextNode = x.parent.right;
        while(nextNode.left != null || nextNode.right != null){
            if(nextNode.left != null){
                nextNode = nextNode.left;
            }else{
                nextNode=nextNode.right;
            }
        }
        return nextNode;
    }

    public static Node inOrderNext(Node x){
        if(x.right != null){
            Node nextNode = x.right;
            while(nextNode.left != null){
                nextNode = nextNode.left;
            }
            return nextNode;
        }else{
            while(x.parent != null && x == x.parent.right){
                x = x.parent;
            }
            return x.parent;
        }
    }
    //question 2

    private static boolean helperMethod(Node node, Integer min, Integer max){
        if (node == null){
            return true;
        }else if((min != null && node.data < min) || (max != null && node.data > max) ){
            return false;
        }else{
            return helperMethod(node.left, min, node.data) && helperMethod(node.right, node.data, max);
        }
    }
    public static boolean isBinarySearchTree(Node root){
        return helperMethod(root, null, null);
    }
}



