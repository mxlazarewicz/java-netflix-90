package pl.yellowduck.netflix90.resources;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.*;

import java.math.BigDecimal;
import java.util.Set;

public class UniqueVideoCassetteCatalogTest {

    @Test
    public void shouldNotAddSameIdVideCassette() {
        // given
        VideoCassette videoCassette1 = new VideoCassette(
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                new Category( "Drama", "Drama movie type"),
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        VideoCassette videoCassette2 = new VideoCassette(
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                new Category( "Drama", "Drama movie type"),
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        IVideoCassetteCatalog catalog = new UniqueVideoCassetteCatalog();
        // when
//        catalog.addVideoCassette(videoCassette1, videoCassette2);
        // then
        Assertions.assertThat(catalog.getAll())
                .hasSize(1);
    }
}