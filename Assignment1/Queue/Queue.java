
package queue;

/**
 *
 * @author Andrew Mackay
 */



import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Queue implements QueueInterface {

    ArrayList<Integer> data = new ArrayList<>();
    int cursor = 0; // Cursor is the index that is the front of the queue
    
    @Override
    public void enqueue(int val) {
        data.add(val);
    }

    @Override
    public int dequeue() {
        
        // Make sure the queue is not empty, otherwise throw exception
        if ( isEmpty() )
            throw new NoSuchElementException("There are no items to dequeue!");
        
        // Get the item at the cursor position
        int val = data.get(cursor);
        
        // Advance the cursor to the next position
        cursor++;
        
        return val;
    }
    
    public int getRandom() {
        int randIdx = (int)(Math.random() * (size() - cursor)) + cursor;
        return data.remove(randIdx);
    }
    
    @Override
    public void print() {
        for ( int i = cursor; i < data.size(); i++ )
            System.out.println(data.get(i));
    }  

    @Override
    public int size() {
        return this.data.size() - cursor;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
