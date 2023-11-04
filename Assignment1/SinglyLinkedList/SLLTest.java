
package singlyLinkedList;

import java.util.ArrayList;

/**
 *
 * @author Andrew Mackay
 */
public class SLLTest {
    public static void main(String[] args) {
        
        SinglyLinkedList myList = new SinglyLinkedList();
        int N = 500000;
        
        for ( int i = 0; i < N; i++ ) {
            myList.add(123);
        }
        
        long startTime = System.currentTimeMillis();
        
        System.out.println( myList.get(0) );
        
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        
        System.out.println( elapsedTime + " ms");
        
        // Index 0: 
        // Index 250000: 
        // Index 500000: 
    }
}
