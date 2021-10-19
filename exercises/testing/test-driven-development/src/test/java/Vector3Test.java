import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import static org.junit.jupiter.api.Assertions.assertThrows;

final class Vector3Test {

    @Test
    public void isZero() {
        Vector3 v = new Vector3(0, 0, 0);
        assertThat(v.getX(), is(0.0));
        assertThat(v.getY(), is(0.0));
        assertThat(v.getZ(), is(0.0));
    }

    @Test
    public void dotProductShouldReturnTheCorrectValue() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);
        assertThat(v1.dot(v2), is(32.0));
    }

    @Test
    public void dotProductWithAZeroVectorReturnZero() {
        Vector3 v1 = new Vector3(0, 0, 0);
        Vector3 v2 = new Vector3(4, 5, 6);
        assertThat(v1.dot(v2), is(0.0));
    }

    @Test
    public void theVectorLengthShouldBeCorrect() {
        Vector3 v = new Vector3(2, 2, 1);
        assertThat(v.length(), is(3.0));
    }

    @Test
    public void crossProductShouldBeCorrect() {
        Vector3 v1 = new Vector3(1, 2, 3);
        Vector3 v2 = new Vector3(4, 5, 6);
        // x = 2*6-3*5 = 12 -15
        // y = 3*4-1*6 = 12 - 6
        // z = 1*5-2*4 = 5-8
        assertThat(v1.cross(v2), is(new Vector3(-3, 6, -3)));
    }

    @Test
    public void normalizeShouldBeCorrect() {
        Vector3 v1 =  new Vector3(2, 2, 1);
        assertThat(v1.norm(), is(new Vector3(2./3, 2./3, 1./3)));
    }

    @Test
    public void normalizeWithALengthZeroShouldReturnZero() {
        Vector3 v1 = new Vector3(0, 0, 0);
        assertThat(v1.norm(), is(new Vector3(0, 0, 0)));
    }

    @Test
    public void scaleShouldBeCorrect() {
        Vector3 v1 = new Vector3(1, 2, 3);
        assertThat(v1.scale(5), is(new Vector3(5, 10, 15)));
    }
}
