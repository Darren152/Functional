package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
//        Object value = Optional.ofNullable("Hello")
//                .orElseGet(() -> "default value");
//        System.out.println(value);

//        Object value = Optional.ofNullable("Hello")
//                .orElseThrow(() -> new IllegalStateException("exception"));
//        System.out.println(value);

//        Optional.ofNullable("john@gmail.com")
//                .ifPresent(email -> System.out.println("Sending email to "+ email));

        Optional.ofNullable("darren12@gmail.com")
                .ifPresentOrElse(email -> System.out.println("Sending email to "+ email),
                        () -> System.out.println("Cannot send email"));
    }
}
