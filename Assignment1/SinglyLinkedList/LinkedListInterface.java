package linkedList;




/**
 *
 * @author Andrew Mackay
 */
public interface LinkedListInterface {
    public int get(int index);
    public int getMin();
    public int getMax();
    public int size();
    public void add(int value);
    public boolean remove(NodeInterface toRemove);
    public boolean removeIndex(int index);
    public void print();
    public void reverse();
}
