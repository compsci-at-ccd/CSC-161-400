package edu.ccd;

public class BreakAndContinue {
    public BreakAndContinue() {
        System.out.println("\n-- Break and Continue Statements");
        //countToTenBreak();
        countByTwosWithContinue();
    }

    private void countToTenBreak(){
        int counter = 0;
        for(;;) {
            System.out.println("The 'counter' variable in the 'for' loop is: " + ++counter);
            if(counter >= 10) break;
        }
    }
    private void countByTwosWithContinue() {
        for(int counter = 0; counter <= 20; ++counter) {
            System.out.println("The 'counter' variable in the 'for' loop is: " + counter);
            if ( (counter % 2 == 1) ? false : true ) {
                counter++;
                continue;
            }
            System.out.println("This statement never prints, and yet is not detected as unreachable. Why?");
        }
    }
}
