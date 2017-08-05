package ml.pevgen.examples;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by user on 05.08.2017.
 */
public class PredicateUtils {


    public static Predicate<Person> isAdult(){
        return person -> person.getAge() > 18;
    }

    public static Predicate<Person> isKid(){
        return person -> person.getAge() > 4;
    }

    public static Predicate<Person> isTeen(){
        return person -> person.getAge() > 15;
    }



    public static List<Person> filter(List<Person> persons, Predicate<Person> predicate){
        return persons.stream().filter(predicate).collect(Collectors.toList());
    }

}
