package edu.grinnell.csc207.mysteries;

import java.util.Scanner;

class Counter {
    public int value;
    public Counter() { this.value = 0; }
    public void increment() { this.value += 1; }
    public static void main(String[] args) {
        Counter c1 = new Counter();
        Counter c2 = new Counter();
        System.out.println("Are c1 and c2 equal? " + (c1 == c2));
    }
}

public class Ref {
    public static void main(String[] args) {
        // Snippet 1
        String s1 = "hello";
        String s2 = "hello";
        System.out.println(s1 == s2);

        // Snipper 2
        Scanner in = new Scanner(System.in);
        String s3 = in.nextLine();    // Suppose the user types the same
        String s4 = in.nextLine();    // line for both s3 and s4...
        System.out.println(s3 == s4);
    }  
}
