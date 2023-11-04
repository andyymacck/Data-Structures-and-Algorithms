
package queue;

/**
 *
 * @author Andrew Mackay
 */
public class QueueTest {
    
    public static void main(String[] args) {
        
        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.print();
        
    }
}
