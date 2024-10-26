package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class RunnerTest {
    @Test
    void testArea() {
        Runner triangle = new Runner();
        assertThrows(RequiredValueMissingException.class, 
            () -> triangle.run("1,2".split(",")));
    }

    @Test
    void testMain() throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        Runner.main("3,4,5".split(","));
        out.close();
        assertEquals("6.0" + System.getProperty("line.separator"), new String(out.toByteArray()));
    }
}
