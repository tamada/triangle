package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NegativeValueExceptionTest {
    private Exception exception;

    @BeforeEach
    public void setUp() {
        this.exception = new NegativeValueException("message");
    }

    @Test
    void testInstance(){
        assertInstanceOf(NegativeValueException.class, exception);
        assertEquals("message", exception.getMessage());
    }
}
