import java.util.Scanner;

public final class Terminal {
    public static void main() {
        // Print to stdout (Standard output in terminal
        System.out.println("Hello World!");

        // Print to the stderr (Useful for errors)
        System.err.println("This is an error!");

        // Print a line with multiple statements;
        System.out.print("Foo ");
        System.out.print("Bar ");
        System.out.print("Baz");
        System.out.println();

        // Printf (f = format) allows formatting a string
        // Allows formatting primitive types and others.
        // We primarily used the following:
        // %s - String
        // %f - floating point number (float, double)
        // %d - decimal number (int, long)
        String ex1 = String.format("%s - %f - %d", "String", 42.0f, 69);
        System.out.println(ex1);

        // This is possible directly on the stdout.
        // Number formatting can also be adjusted, for example
        // %.3f  - 3 decimal digits
        // %.4f  - 4 decimal digits
        // %5.1f - 1 decimal digit, 5 characters in total
        System.out.printf("%.3f \n", 1.234567f);
        System.out.printf("%.4f \n", 1.2);
        System.out.printf("%5.1f \n", 1.2);

        // strg+click on {format} in {String.format} to see the whole manual

        // Since Java 25, there is a new util for printing to the stdout
        // The namespace {IO} contains lots of helpers:
        IO.println("Hello World"); // same as System.out.println
        IO.print("Foo"); IO.print("Bar"); IO.print("Baz"); IO.println(); // same as System.out.print

        // {IO} also contains simple helpers for reading:
        String a1 = IO.readln("What is your favourite animal?: "); // opens a prompt on the commandline asking the user for input
        System.out.printf("Your favourite animal is %s\n", a1);

        // Alternatively, the {Scanner} class can be used
        Scanner scanner = new Scanner(System.in); // Read from stdin (Terminal standard input)

        // Don't close scanner (scanner.close();) - it will close the stdin stream, and it can't be opened again.

        System.out.print("What's your name?: ");
        String prompt1 = scanner.next();
        System.out.printf("Your name is %s\n", prompt1);

        System.out.print("How old are you?: ");
        int prompt2 = scanner.nextInt();
        System.out.printf("You are %d\n", prompt2);
    }
}