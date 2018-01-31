package edu.ccd;

public class CharAndASCII {

    public CharAndASCII() {
        System.out.println("\n-- Characters and ASCII --");
        whatIsAChar();
    }

    private void whatIsAChar() {
        //what exactly is a 'char'?
        char theLetterA = 65;

        System.out.println("What exactly is a 'char'? This one is " + theLetterA);
        System.out.println("But then why can I divide 1340 by it and get " + (1340f/theLetterA) + "?");
    }
}
