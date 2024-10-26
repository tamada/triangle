package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RequiredValueMissingExceptionTest {
    private Exception exception;

    @BeforeEach
    void setUp() {
        this.exception = new RequiredValueMissingException("message");
    }

    @Test
    void testInstance(){
        assertInstanceOf(RequiredValueMissingException.class, exception);
        assertEquals("message", exception.getMessage());
    }
}
