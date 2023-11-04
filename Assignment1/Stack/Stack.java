
package stack;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 *
 * @author Andrew Mackay
 */
public class Stack implements StackInterface {
    
    // The first element is the bottom of the stack
    // The last element is the top of the stack
    ArrayList<Integer> data = new ArrayList<>();

    @Override
    public void push(int val) {
        this.data.add(val);
    }

    @Override
    public int pop() {
        
        // Throw an exception if the stack is empty
        if ( this.isEmpty() )
            throw new NoSuchElementException("Cannot pop from an empty stack.");
        
        // Get the index of the last element
        int lastIdx = data.size() - 1;
        
        // Get the value at the last position (top of the stack), then remove.
        int val = this.data.remove(lastIdx);
        return val;
    }

    @Override
    public int min() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
        return data.size();
    } 
    
    public boolean isEmpty() {
        return size() == 0;
    }
    
    @Override
    public void print() {
        System.out.println("TOP");
        
        // Pop all items in the stack and print them. Store items temporarily in
        // a temp stack
        Stack temp = new Stack();
        
        while ( !this.isEmpty() ) {
            int val = this.pop();
            System.out.println(val);
            
            // Temporarily hold value in temp stack
            temp.push( val );
        }
        
        // Once we have printed everything, put everything back in the stack
        while ( !temp.isEmpty() ) {
            int val = temp.pop();
            this.push( val );
        }
    }
}
