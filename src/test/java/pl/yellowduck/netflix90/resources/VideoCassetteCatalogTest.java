package pl.yellowduck.netflix90.resources;


import org.junit.Test;
import pl.yellowduck.netflix90.common.Gender;
import pl.yellowduck.netflix90.films.*;

import java.math.BigDecimal;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class VideoCassetteCatalogTest {


    // test sprawdza czy utworzony katalog jest wyjsciowo pusty
    @Test
    public void shouldCreateCatalogThatIsEmpty() {
        // when
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        // then
        assertThat(catalog.getAll()).isEmpty();
    }

    @Test // org.junit.Test
    public void shouldAddVideoCassetteToCatalog() {
        // given
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
        VideoCassette videoCassette = new VideoCassette(
                BigDecimal.valueOf(20),
                "The room",
                new Director("Tommy", "Wiseau", Gender.MALE),
                new Category( "Drama", "Drama movie type"),
                Set.of(new Actor("Tommy", "Wiseau", Gender.MALE)));

        // when
//        catalog.addVideoCassette(videoCassette);

        // then
        assertThat(catalog.getAll())
                .hasSize(1);
    }

    @Test // org.junit.Test
    public void shouldAddVideoCassettesToCatalog() {
        // given
        IVideoCassetteCatalog catalog = new VideoCassetteCatalog();
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

        // when
        // mozna tak ale lepiej udostepnic metode do zlozonej operacji
//        for (VideoCassette cassette : List.of(videoCassette1, videoCassette2)) {
//            catalog.addVideoCassette(cassette);
//        }
//        catalog.addVideoCassette(videoCassette1, videoCassette2);

        // then
        assertThat(catalog.getAll())
                .hasSize(2);
    }
}
