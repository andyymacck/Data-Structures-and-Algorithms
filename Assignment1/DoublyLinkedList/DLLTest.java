package doublyLinkedList;


/**
 *
 * @author Andrew Mackay
 */
public class DLLTest {
    
    public static void main(String[] args) {
        
        // Create list and populate
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.add(123);
        myList.add(246);
        myList.add(369);
        myList.add(888);
        myList.print();
        System.out.println("DLL size is " + myList.size());
        System.out.println("The last item in the list is: " + myList.get(3));
        
        myList.removeIndex(0);
        System.out.println("After removing item...");
        myList.print();
        System.out.println("DLL size is " + myList.size());
        System.out.println("The minimum item is: " + myList.getMin());
        System.out.println("The maximum item is: " + myList.getMax());
    }
}
