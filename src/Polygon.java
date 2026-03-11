public class Polygon
{
    private final Point[] points;
    private final Style style;
    public Polygon(Point[] points, Style style)
    {
        this.style = style;
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) this.points[i] = new Point(points[i]);
    }
    public Polygon(Polygon p)
    {
        this.style = p.style;
        points = new Point[p.points.length];
        for (int i = 0; i < points.length; i++) points[i] = new Point(p.points[i]);
    }
    public Point[] getPoints() { return points; }
    public String toString()
    {
        StringBuilder out = new StringBuilder("{");
        for (int i = 0; i < points.length; i++)
        {
            out.append(points[i].toString());
            if (i != points.length - 1) out.append(", ");
        }
        return out + "}";
    }
    public String toSVG()
    {
        StringBuilder out = new StringBuilder("<polygon points=\"");
        for (int i = 0; i < points.length; i++)
        {
            out.append(points[i].toString());
            if (i != points.length - 1) out.append(" ");
        }
        out.append("\" ");
        if (style != null) out.append(style.toSvg()).append(" ");
        else out.append("style=\"fill:#FF00FF00;stroke-width:1;stroke:black\" ");
        return out.append("/>").toString();
    }
}
