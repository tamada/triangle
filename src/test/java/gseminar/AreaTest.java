package gseminar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AreaTest {
    private Area area;

    @BeforeEach
    public void setUp() {
        this.area = new Area(13.0);
    }

    @Test
    public void testArea(){
        assertEquals(13.0, area.area, 1E-6);
    }

    @Test
    public void testPrintln(){
        StringWriter out = new StringWriter();
        area.println(new PrintWriter(out));
        assertEquals("13.0" + System.getProperty("line.separator"), out.toString());
    }
}
