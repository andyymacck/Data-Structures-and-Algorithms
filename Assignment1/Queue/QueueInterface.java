
package queue;

/**
 *
 * @author Andrew Mackay
 */
public interface QueueInterface {
    public void enqueue(int val);
    public int dequeue();
    public int size();
    public boolean isEmpty();
    public void print();
}
