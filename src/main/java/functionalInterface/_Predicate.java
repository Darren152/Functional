package functionalInterface;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {

        System.out.println("Without Predicate");
        System.out.println(isPhoneNumberValid("07000873000"));
        System.out.println(isPhoneNumberValid("0700087300"));
        System.out.println(isPhoneNumberValid("09000873000"));

        System.out.println("With Predicate");
        System.out.println(isPhoneNumberValidPredicate.test("07000873000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700087300"));
        System.out.println(isPhoneNumberValidPredicate.test("09000873000"));


        System.out.println("Is Phone number valid and contains number 3: "+
                isPhoneNumberValidPredicate.and(containsNumber3).test("09000873000"));

        System.out.println("Is Phone number valid and contains number 3: "+
                isPhoneNumberValidPredicate.and(containsNumber3).test("07000873000"));

        System.out.println("Is Phone number valid and contains number 3: "+
                isPhoneNumberValidPredicate.or(containsNumber3).test("08000872030"));
    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") & phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") & phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
