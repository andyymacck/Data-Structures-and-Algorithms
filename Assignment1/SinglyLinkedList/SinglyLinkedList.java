
package singlyLinkedList;

/**
 *
 * @author Andrew Mackay
 */
public class SinglyLinkedList {
    
    public Node head;
    
    public void add(int val) {
        Node newNode = new Node();
        newNode.value = val;
        
        // If the list is empty, define the node
        if ( head == null )
            this.head = newNode;
        
        // If the list is NOT empty, add the node to the last node.
        else {
            // Locate the last node in our list
            Node currNode = head;
            while ( currNode.next != null ) // When we reach the end, next is going to be null.
                currNode = currNode.next;
                        
            // Once we found our last node, we want to attach our new node to it
            currNode.next = newNode;
        }
    }
    
    public int get(int index) {
        
        // Make sure the index is non-negative
        if ( index < 0 )
            throw new IndexOutOfBoundsException("Indices cannot be negative.");
        
        // Iterate through the list until we reach our desired index.
        Node currNode = head;
        for ( int i = 0; i < index; i++ ) {
            if ( currNode.next == null ) // Is there a next element to advance to?...
                throw new IndexOutOfBoundsException("Cannot get index " + index + " in this list.");
            else
                currNode = currNode.next;
        }
        
        return currNode.value; // If the value exists, we return it
    }
    
    // Print our LL to the console
    public void print() {
        Node currNode = head;
        
        // If we do not have a first node, say that the list is empty.
        if ( currNode == null )
            System.out.println("The list is empty!");
        
        else {
            do {
                System.out.println( currNode.value);
                currNode = currNode.next;
            }
            while ( currNode != null );
        }    
    }
}
