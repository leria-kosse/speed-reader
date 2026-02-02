package edu.grinnell.csc207.mysteries;

class StaticCounterExample {
    public static int value;
    public StaticCounterExample() {
        value = 0;
    }
    public void increment(int value) {
        this.value += value;
    }
}

public class StaticExample {
    public void printGreeting() {
        System.out.println("Hello World!");
    }

    public static void main(String[] args) {
        // Uncomment this line and find out if it works!
        // printGreeting();
    }
}
