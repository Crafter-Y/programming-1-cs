public class Interfaces {
    public static void main() {
        // interfaces provide a way to define behavior without implementation
        // it defines the outline of a class and leaves the actual implementation open to another developer
        // interfaces are useful since their description can be used as a type disregarding the actual implementation
        // they therefore provide a contract for developers to follow

        RelevantAPI firstImpl = new APIProvider();
        RelevantAPI secondImpl = new BetterAPIProvider();

        firstImpl.behaviourDefiningFunction();
        System.out.println(firstImpl.description());
        System.out.println(firstImpl.calculate(10, 2));

        System.out.println(secondImpl.description());
        System.out.println(secondImpl.calculate(10, 2));

        // interfaces can also be implemented anonymously:
        RelevantAPI thirdInplace = new RelevantAPI() {
            @Override
            public void behaviourDefiningFunction() {
                // lets do nothing here
                return;
            }

            @Override
            public int calculate(int first, int second) {
                return Math.max(first, second);
            }
        };
    }

    private interface RelevantAPI {
        void behaviourDefiningFunction();
        int calculate(int first, int second);

        // default methods can contain a limited set of operations and get created on any implementing class
        default String description() {
            return "This is the relevant API implementation";
        }
    }

    private static final class APIProvider implements RelevantAPI {

        @Override
        public void behaviourDefiningFunction() {
            System.out.println("This is none of your business!");
        }

        @Override
        public int calculate(int first, int second) {
            return first * second;
        }
    }

    private static final class BetterAPIProvider implements RelevantAPI {

        @Override
        public void behaviourDefiningFunction() {
            throw new ArithmeticException("We cannot do that here!");
        }

        @Override
        public int calculate(int first, int second) {
            return first - second;
        }

        @Override
        public String description() {
            return "The other implementation stinks!";
        }
    }
}
