package gseminar;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

public class Triangle {
    public void run(String[] args) throws IOException {
        Sides sides = parseEachSides(args);
        Area areaOfTriangle = sides.calculateArea();
        areaOfTriangle.println(createPrintWriter(System.out));
    }

    private Sides parseEachSides(String[] args) {
        if(args.length != 3)
            throw new RequiredValueMissingException("missing");
        return new Sides(args[0], args[1], args[2]);
    }

    private PrintWriter createPrintWriter(PrintStream out) throws IOException {
        return new PrintWriter(new OutputStreamWriter(out, "utf-8"));
    }

    public static void main(String[] args) throws IOException {
        Triangle triangle = new Triangle();
        triangle.run(args);
    }
}
