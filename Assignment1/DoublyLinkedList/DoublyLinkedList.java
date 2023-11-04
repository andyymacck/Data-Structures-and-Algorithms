
package doublyLinkedList;

import linkedList.LinkedListInterface;
import linkedList.NodeInterface;
import java.lang.IndexOutOfBoundsException;

/**
 *
 * @author Andrew Mackay
 */
public class DoublyLinkedList implements LinkedListInterface {

    public Node head;
    public Node tail;
    public int size = 0;    
    
    @Override
    public int get(int index) {
        
        // Determine if we want to start counting from the head or the tail
        int listSize = size();
        
        // Make sure that the index is within the bounds of the list
        if ( index < 0 || index >= listSize )
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        
        // If the target index is closer to the head, start counting from the
        // start of the list
        Node currNode;
        if ( index < listSize / 2 ) {
            currNode = head;
            for ( int i = 0; i < index; i++ ) {
                
                // Advance the iteration
                currNode = currNode.next;
            }
        }
        
        // Otherwise, we start counting BACKWARDS from the tail
        else {
            currNode = tail;
            for ( int i = listSize - 1; i > index; i-- ) {
                
                // Advance the iteration
                currNode = currNode.previous;
            }
        }
        
        // Finally, return the value of the node
        return currNode.value;
    }

    @Override
    public int getMin() {
        
        // If the list is empty, throw an exception.
        if ( head == null )
            throw new IllegalStateException( "Cannot get the minimum of an empty list." );
        
        // Iterate through the list entirely and keep track of the smallest element
        Node currNode = head;
        int minVal = Integer.MAX_VALUE;
        
        do {
            
            // See if the current value is smaller than the current minimum.
            if ( currNode.value < minVal )
                minVal = currNode.value;
            
            // Advance
            currNode = currNode.next;
        }
        while( currNode != null );
        
        return minVal;
    }

    @Override
    public int getMax() {
        
        // If the list is empty, throw an exception.
        if ( head == null )
            throw new IllegalStateException( "Cannot get the maximum of an empty list." );
        
        // Iterate through the list entirely and keep track of the largest element
        Node currNode = head;
        int maxVal = Integer.MIN_VALUE;
        
        do {
            
            // See if the current value is greater than the current maximum.
            if ( currNode.value > maxVal )
                maxVal = currNode.value;
            
            // Advance
            currNode = currNode.next;
        }
        while( currNode != null );
        
        return maxVal;
    }

    @Override
    public void add(int value) {
        
        // Create new node
        Node newNode = new Node();
        newNode.value = value;
        
        // If the list is empty, all we need to do is assign the new node as the
        // head AND the tail
        if ( this.head == null ) {
            this.head = newNode;
            this.tail = newNode;
        }
        
        // If the list is NOT empty
        else {
        
            // Connect the current tail to the new node
            tail.next = newNode;
            
            // Since this is doubly linked, we need to connect the new node to the
            // old tail
            newNode.previous = tail;
            
            // Update the tail
            this.tail = newNode;
        }
        
        // Increment size
        size++;
    }
    
    @Override
    public boolean remove(NodeInterface toRemoveNode) {
        
        // Get the neighbours of the node we want to delete
        Node toRemove = ((Node) toRemoveNode);
        Node previousNode = toRemove.previous;
        Node nextNode = toRemove.next;
        
        // Break the connect between previous --> toRemove
        if ( previousNode != null )
            previousNode.next = nextNode;
        
        // Break the connection between toRemove <--- next
        if ( nextNode != null )
            nextNode.previous = previousNode;
        
        // Update the head if changed
        if (toRemove == head)
            this.head = nextNode;
        
        // Update the tail if changed
        if (toRemove == tail)
            this.tail = previousNode;
        
        // Decrement the size
        size--;
        
        return true;
    }

    @Override
    public boolean removeIndex(int index) {
        
        // Make sure that the index is non-negative
        if ( index < 0 )
            return false; // No items exist at negative indices
        
        // Start counting from the head until we reach the desired node
        Node currNode = head;
        
        for ( int i = 0; i < index; i++ ) {
            currNode = currNode.next;
            
            // Null-check (out of bounds)
            if ( currNode == null )
                return false;
        }
        
        // currNode is the node we want to remove.
        remove( currNode );
        return true;
    }
    
    @Override
    public int size() {
        return this.size;
    }

    @Override
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

    @Override
    public void reverse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
