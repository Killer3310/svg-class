public class Segment {
    public Point a = new Point(0, 0), b = new Point(1, 1);
    public Segment() { }
    public Segment(Point a, Point b)
    {
        this.a = new Point(a);
        this.b = new Point(b);
    }
    public float length()
    {
        float dx = a.x - b.x, dy = a.y - b.y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }
}
