public class Recursion {
    public static void main() {
        // In algorithm design, there are usually 2 approaches: iterative and recursive
        // iterative designs usually use for and while loops to iterate a fixed amount of times or until a condition
        // is reached. all execution lies in a linear execution order, usually with a fixed amount of memory used
        // recursive designs have functions that call themselves. Prominent examples are divide-and-conquer algorithms
        // splitting down a problem into a subset of itself until the simplest problem is reached

        // For example, lets implement multiplication in an iterative and recursive manner.

        int number1 = 12;
        int number2 = 4;

        // iterative:
        int itResult = 0;
        for (int i = 0; i < number2; i++) {
            itResult += number1;
        }
        System.out.println("Iterative result is: " + itResult);

        // recursive:
        int recursiveResult = multiply(number1, number2);
        System.out.println("Recusrive result is: " + recursiveResult);
    }

    private static int multiply(int first, int second) {
        if (second < 0) { // only needed to support negative second numbers
            second = -second;
            first = -first;
        }
        if (first == 0 || second == 0) return 0;
        return first + multiply(first, second - 1); // the recursive call
    }
}
