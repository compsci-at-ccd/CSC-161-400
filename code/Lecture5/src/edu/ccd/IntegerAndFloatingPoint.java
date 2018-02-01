package edu.ccd;

public class IntegerAndFloatingPoint {

    public IntegerAndFloatingPoint() {
        System.out.println("\n-- Integer and Floating Point Numbers --");
        playWithIntegers();
        playWithFloats();
    }

    private void playWithIntegers() {
        //The underscore character is a legal separator!
        //and note the 'l' at the end of the digits; this denotes that the number should be
        //interpreted at a long - the default is 'int' (try removing the 'l' and see what happens!)
        long longnum = 9_223_372_036_854_775_807l;

        //Can I use an integer to hold the number 'longnum'?
        if (longnum < Integer.MAX_VALUE) {
            //if 'longnum' is small enough, this line causes a demotion cast to int
            System.out.println("I can store " + (int) longnum + " as an int.");
        } else {
            System.out.println("I cannot store " + longnum + " as an int.");
        }
    }
    private void playWithFloats() {
        //I can do the same thing with float and double
        double dblnum = 1.6d;
        if (dblnum < Float.MAX_VALUE) {
            System.out.println("I can store " + (float) dblnum + " as a float.");
        }else {
            System.out.println("I cannot store " + dblnum + " as a float.");
        }

        //What happens if I make dblnum an int?
        System.out.println("Forcing " + dblnum + " into an int makes " + (int)dblnum);
        System.out.println("If I meant to 'round', it would then be " + Math.round(dblnum));
    }
}
