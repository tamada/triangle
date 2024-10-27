package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class TriangleTest {
    @Test
    void testBasic() {
        Triangle sides = new Triangle(3, 4, 5);
        Area area = sides.calculateArea();
        assertEquals(6.0, area.area, 1E-6);
    }

    @Test
    void testObtuseTriangle() {
        assertTrue(new Triangle(3, 4, 6).isObtuse());
        assertTrue(new Triangle(4, 6, 3).isObtuse());
        assertTrue(new Triangle(6, 3, 4).isObtuse());
    }

    @Test
    void testAcuteTriangle() {
        assertTrue(new Triangle(4, 5, 6).isAcute());
        assertTrue(new Triangle(5, 6, 4).isAcute());
        assertTrue(new Triangle(6, 4, 5).isAcute());
    }

    @Test
    void testScaleneTriangle() {
        assertTrue(new Triangle(3, 4, 5).isScalene());
        assertTrue(new Triangle(4, 5, 3).isScalene());
        assertTrue(new Triangle(5, 3, 4).isScalene());
    }

    @Test
    void testIsoscelesTriangle() {
        assertTrue(new Triangle(1, 1, 1).isIsosceles());
        assertTrue(new Triangle(3, 2, 2).isIsosceles());
        assertTrue(new Triangle(2, 3, 2).isIsosceles());
        assertTrue(new Triangle(2, 2, 3).isIsosceles());
    }

    @Test
    void testRightTriangle() {
        assertTrue(new Triangle(3, 4, 5).isRight());
        assertTrue(new Triangle(4, 5, 3).isRight());
        assertTrue(new Triangle(5, 3, 4).isRight());
    }

    @Test
    void testEquilateralTriangle() {
        assertTrue(new Triangle(5, 5, 5).isEquilateral());
    }


    @Test
    void testNotTriangleException() {
        assertThrows(NotTriangleException.class, () ->  new Triangle(3, 4, 10));
        assertThrows(NotTriangleException.class, () ->  new Triangle(4, 10, 3));
        assertThrows(NotTriangleException.class, () ->  new Triangle(10, 3, 4));
    }

    @Test
    void testNegativeValueException() {
        assertThrows(NegativeValueException.class, () -> new Triangle(4, 4, 0));
        assertThrows(NegativeValueException.class, () -> new Triangle(4, -1, 4));
        assertThrows(NegativeValueException.class, () -> new Triangle(-1, 4, 4));
    }
}
