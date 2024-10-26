package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NotTriangleExceptionTest {
    private Exception exception;

    @BeforeEach
    public void setUp() {
        this.exception = new NotTriangleException("message");
    }

    @Test
    void testInstance(){
        assertInstanceOf(NotTriangleException.class, exception);
        assertEquals("message", exception.getMessage());
    }
}
