public class PrimitiveTypesAndOperations {
    public static void main() {
        // https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
        // Variables can be assigned through their declaration syntax:
        // <type> <name> = <value>;
        byte singleByte = 0x22; // -128 to 127 - probably not needed
        short smallWholeNumber = 16000; // -32,768 to 32,767 - don't use it, modern computers have enough memory
        int wholeNumber = 69; // -2,147,483,648 to 2,147,483,647
        long wholeNumberWithMoreSpace = 1234567891011121314L; // -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float simpleFloat = 69.420f;
        double floatWithDoublePrecision = 4.66666666666;

        boolean trueStatement = true;
        boolean thisStatementIsFalse = false;

        char character = 'G';
        String something = "Hello, this is freetext and also not a primitive type"; // not a primitive type but handled like one

        // Variables can be declared empty and can be assigned later
        int uninitialized;
        // ... other code
        uninitialized = 120;
        // and can be overwritten
        uninitialized = 420;

        // All sorts of maths can be done with values;
        int addition = 69 + 420; // 489
        int sub = 69 - 420; // -351
        int mult = 12 * 4; // 48
        int div = 40 / 10; // 4
        int modulo = 123 % 5; // 3 (24*5 + 3)

        // Important: if floating point numbers are expected, at least one operand needs to be declared floating-point
        float unevenDiv = 12f/10;
        float otherWay = 12/10f;
        float notWorking = 12/10;

        // Increment / Decrement operators
        int toIncrement = 12;
        toIncrement++; // is now 13;
        int incrementBefore = ++toIncrement; // 14
        int incrementAfter = toIncrement++; // 14 as well - toIncrement is 15 after that line

        int toDecrement = 420;
        toDecrement--;

        // Assignment operators
        int mutable = 420;
        mutable += 100; // 520
        mutable -= 5; // 515
        mutable /= 5; // 103
        mutable *= 2; // 206
        mutable %= 2; // 0

        // Bitwise operators
        int op1 = 0b1001;
        int op2 = 0b1010;

        int or = op1 | op2; // 1011
        int and = op1 & op2; // 1000
        int xor = op1 ^ op2; // 0011

        // Shift operators (probably not needed, if you think you need them, you might want to rethink what you are doing)
        int shift = 0b110011;
        int right = shift >> 4; // 11
        int left = shift << 4; // 1100110000

        // Logical operators
        boolean statement = true;
        statement = !statement; // statement is now false

        boolean booleanAnd = true && false; // false
        boolean booleanOr = true || false; // true
        boolean equality = 12 == 12; // true
        boolean inequality = 12 != 12; // false

        // Comparators
        boolean more = 12 > 10; // true
        boolean moreOrEqual = 12 >= 12; // true
        boolean less = 12 < 12; // false
        boolean lessOrEqual = 12 <= 12; // true

        // string manipulation
        String foo = "Foo";
        String bar = "Bar";
        String foobar = foo + bar; // "FooBar"
        foobar += "Baz"; // "FooBarBaz"

        // methods on Strings
        foobar = foobar.toUpperCase(); // "FOOBARBAZ"
        foobar = foobar.toLowerCase(); // "foobarbaz"
        foobar = foobar.concat("\n"); // "foobarbaz\n"
        foobar = foobar.replace("bar", ""); // "foobaz\n"
        foobar = foobar.substring(0, 6); // "foobaz"
        foobar = foobar.indent(1); // " foobaz"
        foobar = foobar.trim(); // "foobaz"
        char secondChar = foobar.charAt(1); // 'o'
        int stringLength = foobar.length(); // 6

        // Wrapper types
        // In some cases you might need them, for example when applying polymorphism
        String sentence = "Hello World!";
        Integer primInt = 123;
        // same for Byte, Double, Long, Float ...

        // For numbers they can be useful to parse input
        String answer = "69420";
        Integer extracted = Integer.parseInt(answer); // this can throw a NumberFormatException
    }
}
