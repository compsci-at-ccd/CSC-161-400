package edu.ccd;

public class PrefixPostfix {
    public PrefixPostfix() {
        System.out.println("\n-- Postfix/Prefix Modes for Increment/Decrement Operators --");
        countBackwardsFromTen();
    }

    private void countBackwardsFromTen() {
        int predec = 10;
        int postdec = 10;
        System.out.println("Predecrement\tPostdecrement");
        do {
            System.out.println( "\t" + new Integer(--predec).toString() + "\t\t\t\t" + new Integer(postdec--).toString() );
        } while (predec > 0);
    }
}
