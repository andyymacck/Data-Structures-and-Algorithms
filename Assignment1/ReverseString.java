/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

import java.util.Scanner;

/**
 *
 * @author Andrew Mackay
 */
public class ReverseString {
    public static void main(String[] args) {
        
        // Take the input string
        System.out.println("Input string:");
        Scanner s = new Scanner(System.in);
        String line = s.nextLine();
        
        // Reverse the string using a stack. Iterate character by character
        //
        // Example
        // Input: cat
        // >[]
        // >[c]
        // >[a, c]
        // >[t, a, c]
        // 
        // Reverse by popping
        // t
        // ta
        // tac
        Stack temp = new Stack();
        for ( char c : line.toCharArray() )
            temp.push(c);
        
        // Now are going to assemble the reversed string from the stack
        String reversed = "";
        while ( !temp.isEmpty() )
            reversed += (char) temp.pop();
        
        // Print reversed string
        System.out.println("Reversed: " + reversed);
    }
}
