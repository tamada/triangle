package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RequiredValueMissingExceptionTest {
    private Exception exception;

    @BeforeEach
    public void setUp() {
        this.exception = new RequiredValueMissingException("message");
    }

    @Test
    public void testInstance(){
        assertInstanceOf(RequiredValueMissingException.class, exception);
        assertEquals("message", exception.getMessage());
    }
}
