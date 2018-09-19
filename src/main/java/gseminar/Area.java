package gseminar;

import java.io.PrintWriter;

public class Area {
    double area;

    public Area(double area) {
        this.area = area;
    }

    public void println(PrintWriter out) {
        out.println(area);
        out.flush();
    }
}
