package edu.ccd;

public class TypeConversions {
    //keep in mind:
    //+--------+---------+---------+---------+
    //| 8 bits | 16-bits | 32-bits | 64-bits |
    //+--------+---------+---------+---------+
    //| byte   | short   | int     | long    |
    //|        | char    | float   | double  |
    //+--------+---------+---------+---------+

    public TypeConversions() {
        System.out.println("\n-- Type Conversions --");
        int i_am_an_int = 5;
        automatic_promotion(i_am_an_int);

    }

    private long automatic_promotion(long x) {
        System.out.println("Multiple function definitions can be avoided like this, by using automatic promotion!");
        System.out.println("This method was called with an int, although requiring a long.");
        return x;
    }
}
