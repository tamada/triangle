package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class Triangle2Test {
    @Test
    void testBasic() {
        Triangle2 t = new Triangle2(3, 4, 5);
        Area area = Triangle2Utils.calculateArea(t);
        assertEquals(6.0, area.area, 1E-6);
    }

    @Test
    void testObtuseTriangle() {
        assertTrue(Triangle2Utils.isObtuse(new Triangle2(3, 4, 6)));
        assertTrue(Triangle2Utils.isObtuse(new Triangle2(4, 6, 3)));
        assertTrue(Triangle2Utils.isObtuse(new Triangle2(6, 3, 4)));
    }

    @Test
    void testAcuteTriangle() {
        assertTrue(Triangle2Utils.isAcute(new Triangle2(4, 5, 6)));
        assertTrue(Triangle2Utils.isAcute(new Triangle2(5, 6, 4)));
        assertTrue(Triangle2Utils.isAcute(new Triangle2(6, 4, 5)));
    }

    @Test
    void testScaleneTriangle() {
        assertTrue(Triangle2Utils.isScalene(new Triangle2(3, 4, 5)));
        assertTrue(Triangle2Utils.isScalene(new Triangle2(4, 5, 3)));
        assertTrue(Triangle2Utils.isScalene(new Triangle2(5, 3, 4)));
    }

    @Test
    void testIsoscelesTriangle() {
        assertTrue(Triangle2Utils.isIsosceles(new Triangle2(1, 1, 1)));
        assertTrue(Triangle2Utils.isIsosceles(new Triangle2(3, 2, 2)));
        assertTrue(Triangle2Utils.isIsosceles(new Triangle2(2, 3, 2)));
        assertTrue(Triangle2Utils.isIsosceles(new Triangle2(2, 2, 3)));
    }

    @Test
    void testRightTriangle() {
        assertTrue(Triangle2Utils.isRight(new Triangle2(3, 4, 5)));
        assertTrue(Triangle2Utils.isRight(new Triangle2(4, 5, 3)));
        assertTrue(Triangle2Utils.isRight(new Triangle2(5, 3, 4)));
    }

    @Test
    void testEquilateralTriangle() {
        assertTrue(Triangle2Utils.isEquilateral(new Triangle2(5, 5, 5)));
    }

    @Test
    void testNotTriangleException() {
        assertThrows(NotTriangleException.class, () ->  new Triangle2(3, 4, 10));
        assertThrows(NotTriangleException.class, () ->  new Triangle2(4, 10, 3));
        assertThrows(NotTriangleException.class, () ->  new Triangle2(10, 3, 4));
    }

    @Test
    void testNegativeValueException() {
        assertThrows(NegativeValueException.class, () -> new Triangle2(4, 4, 0));
        assertThrows(NegativeValueException.class, () -> new Triangle2(4, -1, 4));
        assertThrows(NegativeValueException.class, () -> new Triangle2(-1, 4, 4));
    }
}
