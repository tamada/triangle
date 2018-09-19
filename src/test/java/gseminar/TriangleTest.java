package gseminar;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.closeTo;

public class TriangleTest {
    @Test(expected=RequiredValueMissingException.class)
    public void testArea() throws Exception {
        Triangle triangle = new Triangle();
        triangle.run("1,2".split(","));
    }

    @Test
    public void testMain() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Triangle.main("3,4,5".split(","));
        out.close();
        assertThat(new String(out.toByteArray()), is("6.0" + System.getProperty("line.separator")));
    }
}
