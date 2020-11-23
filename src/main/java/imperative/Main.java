package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static imperative.Main.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("John", Gender.MALE),
            new Person("Maria", Gender.FEMALE),
            new Person("Alex", Gender.MALE),
            new Person("Aisha", Gender.FEMALE),
            new Person("Alice", Gender.FEMALE)
        );

        System.out.println("// Imperative approach");
        // Imperative approach
        List<Person> females = new ArrayList<>();

        for (Person person : people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }

        for (Person female : females){
            System.out.println(female);
        }

        // Declarative Approach
        System.out.println("// Declarative Approach");

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        //Accepts a person and returns true or false based off that persons gender.

        List <Person> females2 = people.stream()
                .filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

        //Same Output as between line 34 and 40
//        people.stream()
//                .filter(person -> FEMALE.equals(person.gender))
//                .collect(Collectors.toList())
//                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE
    }
}
