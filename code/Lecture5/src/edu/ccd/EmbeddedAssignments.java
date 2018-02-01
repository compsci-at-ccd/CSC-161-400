package edu.ccd;

public class EmbeddedAssignments {
    public EmbeddedAssignments() {
        System.out.println("\n-- Embedded Assignments --");
        whyWouldYouDoThis();
    }

    private void whyWouldYouDoThis() {
        int a = 5, b = 3;
        System.out.println("What does this do? " + (b = a));
        System.out.println("But different than..." + (b==a) );

    }
}
