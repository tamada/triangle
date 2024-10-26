package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TriangleTest {
    @Test
    public void testBasic() {
        Triangle sides = new Triangle("3", "4", "5");
        Area area = sides.calculateArea();
        assertEquals(6.0, area.area, 1E-6);
    }

    /**
     * 正三角形．
     */
    @Test
    public void testEquilateralTriangle() {
        Triangle t1 = new Triangle("1", "1", "1");
        Area area = t1.calculateArea();
        assertTrue(t1.isEquilateral());
        assertEquals(Math.sqrt(3)/4, area.area, 1E-6);
    }

    @Test
    public void testNotTriangleException1() {
        assertThrows(NotTriangleException.class, () -> 
            new Triangle("3", "4", "10")
        );
    }

    @Test
    public void testNotTriangleException2() {
        assertThrows(NotTriangleException.class, () -> 
            new Triangle(10, 4, 3)
        );
    }

    @Test
    public void testNotTriangleException3() {
        assertThrows(NotTriangleException.class, () -> 
            new Triangle(4, 10, 3)
        );
    }

    @Test
    public void testNegativeValueException() {
        assertThrows(NegativeArraySizeException.class, () -> 
            new Triangle(4, 4, 0)
        );
    }
}
