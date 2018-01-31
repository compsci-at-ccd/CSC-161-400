package edu.ccd;

public class HexOctalAndBinary {
    public HexOctalAndBinary () {
        System.out.println("\n-- Hexadecimal, Octal and Binary Numbers -- ");
        printoutDifferentBases();
    }

    private void printoutDifferentBases() {
        int test = 1234;
        for (int radix = 2; radix<=16;System.out.println(test + " in base"+radix+" is " + Integer.toString(test, radix++))) {};
    }
}
