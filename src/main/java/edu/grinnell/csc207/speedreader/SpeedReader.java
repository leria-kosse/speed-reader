package edu.grinnell.csc207.speedreader;

import java.awt.*;
import java.io.IOException;

/** TODO: implement this class and add a doc comment! */
public class SpeedReader {
    /**
     * TODO: implement me and add an appropriate doc comment!
     * 
     * @throws IOException
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // Check that we have the correct number of arguments
        if (args.length != 5) {
            System.out.println("Usage: SpeedReader <filename> <width> <height> <font size> <wpm>");
            return;
        }

        // Parse command-line arguments
        String filename = args[0];
        int width = Integer.parseInt(args[1]);
        int height = Integer.parseInt(args[2]);
        int fontSize = Integer.parseInt(args[3]);
        int wpm = Integer.parseInt(args[4]);

        // Create a wordGenerator object
        WordGenerator generator = new WordGenerator(filename);

        // Create a drawing panel
        DrawingPanel panel = new DrawingPanel(width, height);
        Graphics g = panel.getGraphics();
        Font f = new Font("Courier", Font.BOLD, fontSize);
        g.setFont(f);

        int sleepTime = 60000 / wpm;

        while (generator.hasNext()) {
            String word = generator.next();
            g.drawString(word, 100, 100);
            Thread.sleep(sleepTime);
        }

        System.out.println("Words processed: " + generator.getWordCount());
        System.out.println("Sentences processed: " + generator.getSentenceCount());
    }
}
