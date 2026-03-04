public class Segment {
    private Point a = new Point(0, 0), b = new Point(1, 1);
    public Segment() { }
    public Segment(Point a, Point b)
    {
        this.a = new Point(a);
        this.b = new Point(b);
    }
    public float length()
    {
        float dx = a.getX() - b.getX(), dy = a.getY() - b.getY();
        return (float)Math.sqrt(dx * dx + dy * dy);
    }
    public String toString()
    {
        return "{" + a.toString() + ", " + b.toString() + "}";
    }
}
