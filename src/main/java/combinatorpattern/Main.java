package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegValidator.isEmailValid;
import static combinatorpattern.CustomerRegValidator.isPhoneNumberValid;
import static combinatorpattern.CustomerRegValidator.isAnAdult;


public class Main {

    public static void main(String[] args) {
        Customer customer = new Customer(
                "Alice", "alice@gmail.com", "01234567891", LocalDate.of(2000, 1, 1)
        );

        System.out.println(new CustomerValidatorService().isValid(customer));


        // if valid we can store customer in db


        CustomerRegValidator result = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult());

//        System.out.println(result);
//
//        if(result != ValidationResult.SUCCESS){
//            throw new IllegalStateException(result.name())
//        }
    }
}
