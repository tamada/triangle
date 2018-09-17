package gseminar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.is;

public class SidesTest {
    @Test
    public void testBasic() {
        Sides sides = new Sides("3", "4", "5");
        Area area = sides.calculateArea();
        assertThat(area.area, is(closeTo(6.0, 1E-6)));
    }

    /**
     * 正三角形．
     */
    @Test
    public void testEquilateralTriangle() {
        Sides sides = new Sides("1", "1", "1");
        Area area = sides.calculateArea();
        assertThat(area.area, is(closeTo(Math.sqrt(3)/4, 1E-6)));
    }

    @Test(expected=NotTriangleException.class)
    public void testNotTriangleException() {
        Sides sides = new Sides("3", "4", "10");
        Area area = sides.calculateArea();
    }

    @Test(expected=NotTriangleException.class)
    public void testNotTriangleException2() {
        Sides sides = new Sides("10", "4", "3");
        Area area = sides.calculateArea();
    }

    @Test(expected=NotTriangleException.class)
    public void testNotTriangleException3() {
        Sides sides = new Sides("4", "10", "3");
        Area area = sides.calculateArea();
    }

    @Test(expected=NegativeValueException.class)
    public void testNegativeValueException() {
        Sides sides = new Sides("3", "4", "0");
        Area area = sides.calculateArea();
    }
}
