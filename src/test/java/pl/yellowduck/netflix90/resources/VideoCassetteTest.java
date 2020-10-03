package pl.yellowduck.netflix90.resources;

import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.Actor;
import pl.yellowduck.netflix90.films.Category;
import pl.yellowduck.netflix90.films.Director;
import pl.yellowduck.netflix90.films.VideoCassette;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoCassetteTest {

    @Test
    public void shouldVideoCassetteIsEqual() {
        // given
        VideoCassette videoCassette1 = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                new Category( "Drama", "Drama movie type"),
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        VideoCassette videoCassette2 = new VideoCassette(
                "V001",
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                new Category( "Drama", "Drama movie type"),
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));
        // when
        boolean result = videoCassette1.equals(videoCassette2);
        // then
        assertThat(result).isTrue();
        assertThat(videoCassette1.hashCode()).isEqualTo(videoCassette2.hashCode());
    }
}
