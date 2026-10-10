import java.util.Arrays;
import java.util.Collection;

public class ControlStructures {
    public static void main() {
        boolean validStatement = true;
        boolean otherStatement = false;

        // regular if statement
        // the if-block gets evaluated if the first statement is true
        // you can chain as many else-if-branches as you want to
        // the else-branch is the default branch if none of the if-branches match
        // only one branch gets invoked ever
        if (validStatement) {
            // validStatement was evaluated to true
        } else if (otherStatement) {
            // otherStatement was evaluated to true
        } else {
            // none of the branches were selected
        }

        // Ternary if statement
        // <boolean> ? <true-branch> : <false-branch>
        String result = validStatement ? "Valid statement was valid indeed" : "They lied!";

        // For loops allow to iterate over a collection, an array or iterate for a set amount of iterations
        // For IntelliJ users, type "for" and then select fori from the suggestion list to expand the following snippet
        for (int i = 0; i < 100; i++) {
            // This will fire 100 times
        }

        // iterate over a collection
        // For intelliJ users, type "listOfIntegers.for" and expand the snippet to get the following:
        Collection<Integer> listOfIntegers = Arrays.asList(1,2,3,4,5);
        for (Integer integer : listOfIntegers) {
            // this will iterate over every entry in listOfIntegers
        }

        // While loops allow to check a condition iteratively. It is mandatory to mutate the given condition in order
        // to avoid infinite loops
        int loops = 15;
        while (loops != 0) {
            loops--;
            // this will run 15 times
        }

        // A while loop can also be instructed to run once and then check the condition.
        // This ensures that it will run at least one time
        loops = 10;
        do {
            // do whatever here
            loops--;
        } while (loops != 0);

        // control statements can alter the execution flow of loops.

        // break leaves the current loop:
        loops = 10;
        while (loops != 0) {
            if (loops == 5) break;

            loops--;
        }
        // execution will continue here after 5 loops

        // continue skips the current iteration and advances to the next loop iteration
        for (int i = 0; i < 10; i++) {
            if (i == 5) continue;

            // this point will be reached by numbers 0-4 and 6-9
        }

        // control flow labels can be used to resume execution at an arbitrary point
        // this is especially useful for nested loops
        outer:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (i == 5 && j == 5) continue outer;

                // i=5 and j=5-9 wont reach this point
            }
        }

        // infinite loops can be created by passing a true statement to a control flow header
        // they can be useful to orchestrate loops that are truely infinite, for example a render loop that runs until
        // the program gets terminated. In general programming it is advised to avoid them.
        // for infinite loop:
        for(;;) {
            // this will run until it hits a break or the program terminates
            break;
        }

        // while-true-loop
        while(true) {
            // this will run until it hits a break or the program terminates
            break;
        }
    }
}
