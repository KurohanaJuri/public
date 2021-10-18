import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public final class TreasureFinderTest {

    @Test
    void shouldThrowErrorIfGetUserPositionFailed() {
        LocationService ls = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                throw new Exception();
            }
        };

        TreasureFinder tf = new TreasureFinder(ls);
        Position treasurePos = new Position(0.0, 0.0);
        assertThat(tf.getHint(treasurePos), is("The treasure is on Saturn!"));
    }

    @Test
    void shouldGetEasterEgg() {
        LocationService ls = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                return new Position(100.0, 0.0);
            }
        };

        TreasureFinder tf = new TreasureFinder(ls);
        Position treasurePos = new Position(0.0, 0.0);
        assertThat(tf.getHint(treasurePos), is("Nope, the treasure is not at the North Pole."));
    }

    @Test
    void shouldPrintTheCorrectMgsWhenUserIsVeryClose() {
        LocationService ls = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                return new Position(0.00001, 0.0);
            }
        };

        TreasureFinder tf = new TreasureFinder(ls);
        Position treasurePos = new Position(0.0, 0.0);
        assertThat(tf.getHint(treasurePos), is("You're right there!"));
    }

    @Test
    void shouldPrintTheCorrectMgsWhenUserIsClose() {
        LocationService ls = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                return new Position(0.01, 0.0);
            }
        };

        TreasureFinder tf = new TreasureFinder(ls);
        Position treasurePos = new Position(0.0, 0.0);
        assertThat(tf.getHint(treasurePos), is("Close..."));
    }

    @Test
    void shouldPrintTheCorrectMgsWhenUserIsABitFar() {
        LocationService ls = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                return new Position(0.1, 0.0);
            }
        };

        TreasureFinder tf = new TreasureFinder(ls);
        Position treasurePos = new Position(0.0, 0.0);
        assertThat(tf.getHint(treasurePos), is("Not too far."));
    }

    @Test
    void shouldPrintTheCorrectMgsWhenUserIsATooFar() {
        LocationService ls = new LocationService() {
            @Override
            public Position getUserPosition() throws Exception {
                return new Position(1, 0.0);
            }
        };

        TreasureFinder tf = new TreasureFinder(ls);
        Position treasurePos = new Position(0.0, 0.0);
        assertThat(tf.getHint(treasurePos), is("Far away."));
    }

}
