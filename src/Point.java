public class Point {
    public float x = 0, y = 0;
    public String toString()
    {
        return String.format("{%.1f; %.1f}", x, y);
    }
    public String toSVG()
    {
        return String.format(
                "<svg height=\"20\" width=\"20\">\n" +
                "  <circle r=\"1\" cx=\"%s\" cy=\"%s\" fill=\"red\" />\n" +
                "</svg> ",
                (String.valueOf(10 + x)).replace(',', '.'),
                (String.valueOf(10 + y)).replace(',', '.'));
    }
}
