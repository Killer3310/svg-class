public class Polygon
{
    private Point[] points;
    public Polygon(Point[] points)
    {
        this.points = new Point[points.length];
        for (int i = 0; i < points.length; i++) this.points[i] = new Point(points[i]);
    }
    public String toString()
    {
        String out = "{";
        for (int i = 0; i < points.length; i++)
        {
            out += points[i].toString();
            if (i != points.length - 1) out += ", ";
        }
        return out + "}";
    }
    public String toSVG()
    {
        String out = "<polygon points=\"";
        for (int i = 0; i < points.length; i++)
        {
            out += points[i].toString();
            if (i != points.length - 1) out += " ";
        }
        return out + "\" />";
    }
}
