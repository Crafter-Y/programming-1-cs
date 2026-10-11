public class Exceptions {
    public static void main() {
        // Exceptions are a concept found in many programming languages that are designed to aid error handling
        // When an error occurs, a java developer is advised to throw an exception and catch it at another point.

        // To catch exceptions, use the try-catch expressions:
        try {
            // This code gets executed first
            // If any statement raises an error, execution gets resumed inside the catch block.
        } catch (Exception e) {
            // Any exception from the try block gets caught here. This branch only gets executed if an error ocours.
        } finally {
            // This block will always be executed.
        }

        // Example
        try {
            System.out.println("Hello From the try statement");

            throw new Exception("Something went horribly wrong!");

            // This line is unreachable. throw is a control flow expression
        } catch (Exception e) {
            System.out.println("An Exception reached this code block");
            System.out.println("Exception message: " + e.getMessage());
        } finally {
            System.out.println("Nevertheless, this gets executed");
        }

        // Expressions get useful, especially when errors are expected. This is mostly when working with user data.
        // For example: Lets parse a user feedback

        // User gets prompted to input their age:
        String userInput = "Hamburger";
        try {
            int usersAge = Integer.parseInt(userInput);
            System.out.println("The users age is: " + usersAge);
        } catch (NumberFormatException e) {
            System.out.println("The input was not a number!");
        }
    }
}
