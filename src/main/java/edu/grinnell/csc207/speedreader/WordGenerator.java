package edu.grinnell.csc207.speedreader;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;

/**
 * This class is a template for an object that creates a Scanner to read text
 * from input file.
 * It also stores information about the current position in the file (nr of
 * words and sentences read so far).
 * 
 * This class provides methods to check whether there is a next word to be read,
 * to get the next word, and to access wordCount and sentenceCount.
 */
public class WordGenerator {
    private Scanner input;
    private int wordCount;
    private int sentenceCount;

    /**
     * Constructs a new WordGenerator object that processes text from the given
     * file.
     * 
     * @param filename the name of the file to read from
     */
    public WordGenerator(String filename) throws IOException {
        this.input = new Scanner(new File(filename));
        this.wordCount = 0;
        this.sentenceCount = 0;
    }

    /**
     * Checks if there are more words available to read.
     * 
     * @return true or false (whether there is more text)
     */
    public boolean hasNext() {
        return input.hasNext();
    }

    /**
     * Returns the next word from the file.
     * Increments the word count and checks if the word is also the end of a
     * sentence (increments
     * sentenceCount if it is).
     * 
     * @return the next word from the underlying Scanner
     */
    public String next() {
        String nextWord = input.next();
        wordCount++;

        // Check if word ends with sentence-ending punctuation
        if (nextWord.endsWith(".") || nextWord.endsWith("!") || nextWord.endsWith("?")) {
            sentenceCount++;
        }

        return nextWord;
    }

    /**
     * Returns the number of words produced by this WordGenerator so far.
     * 
     * @return the total count of words read
     */
    public int getWordCount() {
        return wordCount;
    }

    /**
     * Returns the number of sentences produced by this WordGenerator so far.
     * 
     * @return the total count of sentences read
     */
    public int getSentenceCount() {
        return sentenceCount;
    }
}
