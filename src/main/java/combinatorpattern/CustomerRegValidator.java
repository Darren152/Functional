package combinatorpattern;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinatorpattern.CustomerRegValidator.*;
import static combinatorpattern.CustomerRegValidator.ValidationResult.*;

public interface CustomerRegValidator extends Function<Customer, ValidationResult> {

    static CustomerRegValidator isEmailValid(){
        return customer -> customer.getEmail().contains("@") ? SUCCESS : EMAIL_NOT_VALID;
    }

    static CustomerRegValidator isPhoneNumberValid(){
        return customer -> customer.getPhoneNumber().startsWith("+0") ? SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustomerRegValidator isAnAdult(){
        return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 17 ? SUCCESS : IS_NOT_AN_ADULT;
    }

    default CustomerRegValidator and (CustomerRegValidator other){
        return customer -> {
            ValidationResult result = this.apply(customer);
            return result.equals(SUCCESS) ? other.apply(customer) : result;
        };
    }

    enum ValidationResult {
        SUCCESS, PHONE_NUMBER_NOT_VALID, EMAIL_NOT_VALID, IS_NOT_AN_ADULT
    }
}
