package edu.ccd;

public class EmptyStatement {
    public EmptyStatement() {
        System.out.println("\n-- Empty Statements --");
        countToTen();
    }
    private void countToTen() {
        for(int index=0; index<10; System.out.println("Inside the 'for' loop, index=" + ++index)) {};
    }
}
