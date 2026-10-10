import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class BuiltInMaths {
    public static void main() {
        // even though you (as the programmer) can technically build everything, it is generally considered bad practise
        // to reinvent the wheel every time. For common mathematical operations, helpers are provided

        // Randomness
        Random random = new Random(); // random utility (java.util.Random);

        int i1 = random.nextInt(); // purely random integer in the integer range
        int i2 = random.nextInt(128); // numbers between 0 and 127
        // nextFloat, nextDouble, nextBoolean ...

        // get a random element from a list
        List<Integer> fixedList = Arrays.asList(0,1,2,3,4,5,6);
        int randomFromList = fixedList.get(random.nextInt(fixedList.size()));
        System.out.println(randomFromList);

        // The build-in Maths library provides common mathematical expressions (java.lang.Math)
        double randomness = Math.random(); // number between 0 and 1

        double pi = Math.PI;
        double e = Math.E;

        // to discover all available methods, ctrl+click on {Math} in your IDE
        // a compiles list of methods is:
        // abs, absExact, acos, addExact, asin, atan, atan2, cbrt, ceil, ceilDiv, ceilMod,
        // copySign, cos, cosh, decrementExact, divideExact, exp, expm1, floor, floorDiv,
        // floorDivExact, floorMod, fma, getExponent, hypot, IEEEremainder, incrementExact, log,
        // log10, log1p, max, min, multiplyExact, negateExact, nextAfter, nextDown, nextUp, pow,
        // random, rint, round, scalb, signum, sin, sinh, sqrt, subtractExact, tan, tanh, toDegrees,
        // toIntExact, toRadians, ulp
    }
}
