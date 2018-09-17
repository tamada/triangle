package gseminar;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.closeTo;

public class AreaTest {
    private Area area;

    @Before
    public void setUp() {
        this.area = new Area(13.0);
    }

    @Test
    public void testArea(){
        assertThat(area.area, is(closeTo(13.0, 0.E-6)));
    }

    @Test
    public void testPrintln(){
        StringWriter out = new StringWriter();
        area.println(new PrintWriter(out));
        assertThat(out.toString(), is("13.0" + System.getProperty("line.separator")));
    }
}
