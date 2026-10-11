public class AbstractClasses {
    public static void main() {
        // when one class extends another, its called polymorphism.
        // a class can be defined normally or as an implicit abstract class. The implementing class needs to use the
        // extends keyword.
    }

    private abstract class BaseClass {
        // normal field
        private final String name;

        // protected field accessible by child class
        protected int age;

        public BaseClass(String name, int age) {
            this.name = name;
            this.age = age;

            System.out.println(methodProvidedByChild());
        }

        // implicit abstract classes can define methods and fields as abstract so their implementing class is forced to
        // provide them
        abstract int methodProvidedByChild();
    }

    private final class ImplementingClass extends BaseClass {
        public ImplementingClass() {
            // this class needs a constructor since the parent class has one and it needs to be called on initialization
            super("Hagrid", 54);

            // we dont have access to this.name
            // but to the age field
            System.out.println(this.age);
        }

        @Override
        int methodProvidedByChild() {
            return 69*420;
        }
    }
}
