package edu.ccd;

public class ConditionalOperator {
    public ConditionalOperator() {
        System.out.println("\n-- Conditional Operator Expressions --");
        aNiceLittleShortcut();
    }

    private void aNiceLittleShortcut() {
        int myTestNum = 10;
        System.out.println("Is 'a' greater than 5? " + ((myTestNum>5)?"Yep.":"Nope."));
    }
}
