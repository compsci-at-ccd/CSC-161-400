package edu.ccd;

public class ShortCircuit {
    public ShortCircuit() {
        System.out.println("\n-- Short-Circuit Evaluation --");
        testWithDivByZero();
    }

    private void testWithDivByZero(){
        boolean isTrue = true;
        if ( isTrue || (6/0>1?true:false) ){
            System.out.println("Short-circuit evaluation can mask issues in code, like this!");
            System.out.println("Try this setting the isTrue variable to 'false' and see what happens!");
        }
    }
}
