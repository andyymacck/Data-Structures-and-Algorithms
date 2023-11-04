public class Node {

    Node left;
    Node right;
    Node parent;
    int data;
    Node preOrder;
    Node inOrder;
    Node postOrder;
    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }


    public Node(int data){
       this.data = data;
   }

    public void preOrderNumber(){
        if(this.left != null){
            preOrder = this.left;
        }
        if(this.right != null){
            preOrder = this.right;
        }
        Node node = this;
        while(node.parent != null){
            if(node.parent.right != null && node != node.parent.right){
                preOrder = node.parent.right;
                break;
            }else{
                node = node.parent;
            }
        }
        System.out.println("There is no next node");
        preOrder = null;
    }

    public void postOrderNumber(){
        if(this.parent == null){
            postOrder = null;
        }
        if(this == this.parent.right ||  this.parent.right == null){
            postOrder = this.parent;
        }
        Node nextNode = this.parent.right;
        while(nextNode.left != null || nextNode.right != null){
            if(nextNode.left != null){
                nextNode = nextNode.left;
            }else{
                nextNode=nextNode.right;
            }
        }
        postOrder = nextNode;
    }

    public void inOrderNumber(){
        if(this.right != null){
            Node nextNode = this.right;
            while(nextNode.left != null){
                nextNode = nextNode.left;
            }
            inOrder = nextNode;
        }else{
            Node node = this;
            while(node.parent != null && node == node.parent.right){
                node = node.parent;
            }
            inOrder = node.parent;
        }
    }
}
