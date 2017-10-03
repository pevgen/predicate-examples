package ml.pevgen.examples.streams;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by user on 03.10.2017.
 */
public class ListStringSplitterStreamTest {
    @Test
    public void testSplit() {
        List<String> tagList = Arrays.asList("tag1", "tag2 tag3", " tag4        tag5    ");
        List<String> resultList =
                tagList.stream()
                        .flatMap(tags -> Arrays.stream(tags.trim().split("\\s+")))
                        .collect(Collectors.toList());
        assertThat(resultList.size()).isEqualTo(5);
        assertThat(resultList.get(0)).isEqualTo("tag1");
        assertThat(resultList.get(4)).isEqualTo("tag5");
    }
}
