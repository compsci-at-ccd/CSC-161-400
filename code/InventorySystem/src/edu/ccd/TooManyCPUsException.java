package edu.ccd;

public class TooManyCPUsException extends Exception {
    public TooManyCPUsException() {
        super("Too many CPUs error.");
    }
}
