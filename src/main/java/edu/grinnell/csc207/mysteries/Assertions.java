package edu.grinnell.csc207.mysteries;

public class Assertions {
    public static int foo1(int x1, int x2) {
        // Point A
        if (x1 < 0 || x2 < 0) {
            return -1;
        }
        // Point B
        int y1 = x1 % 10;
        int y2 = x2 % 10;
        int z = 0;
        // Point C
        if (y1 < y2) {
            z = y1 - y2;
        } else {
            z = y2 - y1;
        }
        // Point D
        return z;
    }

    public static String foo2(String s, char c) {
        String ret = "";
        // Point A
        if (s == null) { throw new IllegalArgumentException(); }
        if (s.length() < 2) { return s; }
        // Point B
        for (int i = 1; i < s.length(); i++) {
            // Point C
            ret += s.charAt(i);
            ret += c;
            // Point D
        }
        // Point E
        return ret;
    }

    public static void main(String[] args) {
        // Fill me in with test code if you'd like!
        System.out.println("Hello world!");
    }
}
