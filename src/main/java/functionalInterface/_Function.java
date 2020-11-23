package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        //Function takes 1 argument and produces 1 result
        int increment = incrementByOne(1);
        System.out.println(increment);

        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        // Chaining functions.
        Function<Integer, Integer> addBy1AndThenMultiplyBy10 =
                incrementByOneFunction.andThen(multiplyBy10Function);
        addBy1AndThenMultiplyBy10.apply(1);
        System.out.println(addBy1AndThenMultiplyBy10.apply(4));

        // BiFunction takes 2 arguments and produces 1 result

        // Using normal Java function
        System.out.println(incrementByOneAndMultiply(4, 100));

        // Using Bi Function
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));

    }

    static Function<Integer, Integer> incrementByOneFunction =
            number -> number + 1;

    static Function<Integer, Integer> multiplyBy10Function =
            number -> number * 10;

    static int incrementByOne (int number){
        return number + 1;
    }

    // "incrementByOneAndMultiplyBiFunction" method is the exact same as "incrementByOneAndMultiply" method
    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMultiply (int number, int numToMultiplyBy){
        return (number + 1) * numToMultiplyBy;
    }
}
