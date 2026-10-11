public class Classes {
    public static void main() {
        // public static void main() is the entrypoint for most Java applications.
        // static methods are uniquely defined and don't belong to an instance of a class

        // with the keyword new, an instance of a class can be made
        Classes instance = new Classes();
    }

    // classes can have fields declared
    // static fields are accessible from every point and hold the same value for all instanced
    private static String mutableStaticValue = "Hello World World";

    // access modifiers define how they can be reached: other options are public or protected
    // non-static values are class bound and dont need to be defined:
    private String name;
    private boolean entryAllowed = true;

    // Any value that is only meant to be set once, should be declared final.
    // static final values are called constants and should be named in upper camel case
    private final String skills;
    private static final String UNUSUAL_CONFIGURATION_CONSTANT = "This may hold up and never change!";

    public Classes() {
        // public <Class name> is the constructor of the class. it gets invoked by the new keyword

        // if a superclass is present, its constructor can be called by the super keyword:
        super();

        // the this keyword always references the instance object and allows data mutation on it
        this.name = "Gustavo";
        this.skills = "None";
    }

    // if a field is declared public, it can be read from outside classes. but this is said to be bad practise
    // instead, a java developer should declare getter and setter methods that offer that mutation interface4
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        // without the this keyword, name would reference the name argument not the instance value.
        this.name = name;
    }
}
