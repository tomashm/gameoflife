package no.finntech.partner.registration;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class GameOfLifeTest {
    @Test
    public void emptyWorld() {
        String world = "..." + "\n" +
                          "..." + "\n" +
                          "...";

        String newWorld = new Game(world).generation();
        assertThat(newWorld).isEqualTo(world).isNotSameAs(world);
    }

    @Test
    public void singleCell() {
        String world =  "..." + "\n" +
                        ".X." + "\n" +
                        "...";

        String newWorld = new Game(world).generation();

        String expected = "..." + "\n" +
                          "..." + "\n" +
                          "...";

        assertThat(newWorld).isEqualTo(expected);
    }


    @Test
    public void newCell() {
        String world =  "XXX" + "\n" +
                        "..." + "\n" +
                        "...";

        String newWorld = new Game(world).generation();

        String expected =  ".X." + "\n" +
                           ".X." + "\n" +
                           "...";

        assertThat(newWorld).isEqualTo(expected);
    }

}