package ml.pevgen.examples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 05.08.2017.
 */
public class PredicateUtilsTest {

    @Test
    public void test() {
        List<Person> personList =
                Arrays.asList(
                        new Person("baby", 1),
                        new Person("kid", 5),
                        new Person("teen", 16),
                        new Person("adult", 20));


        List<Person> babies = PredicateUtils.filter(personList, PredicateUtils.isBaby());
        assertThat(babies.size()).isEqualTo(1);


        List<Person> kids = PredicateUtils.filter(personList,
                PredicateUtils.isKid()
                        .and(PredicateUtils.isTeen().negate()));
        assertThat(kids.size()).isEqualTo(1);

        List<Person> adults = PredicateUtils.filter(personList,
                PredicateUtils.isAdult());
        assertThat(kids.size()).isEqualTo(1);

    }

}
