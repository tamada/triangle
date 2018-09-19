package gseminar;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class NotTriangleExceptionTest {
    private Exception exception;

    @Before
    public void setUp() {
        this.exception = new NotTriangleException("message");
    }

    @Test
    public void testInstance(){
        assertThat(exception, is(instanceOf(NotTriangleException.class)));
    }

    @Test
    public void testGetMessage(){
        assertThat(exception.getMessage(), is("message"));
    }
}
