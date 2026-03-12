public class Point extends Shape
{
    private float x, y;
    public Point() { x = 0; y = 0; }
    public Point(Point p)
	{
		style = new Style("red", "red", 0);
        x = p.x;
        y = p.y;
    }
    public float getX() { return x; }
    public float getY() { return y; }
    public void setX(float x) { this.x = x; }
    public void setY(float y) { this.y = y; }
    public void setXY(float x, float y) { this.x = x; this.y = y; }
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public String toString()
    {
        return String.valueOf(x) + "," + String.valueOf(-y);
    }
    public String toSvg()
	{
		return String.format(
				"<circle r=\"0.05\" cx=\"%f\" cy=\"%f\" %s />",
				x, -y, style.toSvg());
	}

	public BoundingBox getBounds()
	{
		return new BoundingBox(x, y, x, y);
	}
	public Point copy()
	{
		return new Point(this);
	}
    public void translate(Point p)
    {
        x += p.x;
        y += p.y;
    }
    public void translate(float dx, float dy)
    {
        x += dx;
        y += dy;
    }
    public Point translated(Point p)
    {
        return new Point(x + p.x, y + p.y);
    }
    public Point translated(float dx, float dy)
    {
        Point ret = new Point();
        ret.x = x + dx;
        ret.y = y + dy;
        return ret;
    }
    public void rotate90()
    {
        float t = x;
        x = -y;
        y = t;
    }
    public void rotateC90()
    {
        float t = x;
        x = y;
        y = -t;
    }
    public Point negated()
    {
        return new Point(-x, -y);
    }
    public void mul(float f)
    {
        x *= f;
        y *= f;
    }
    public Point muld(float f)
    {
        return new Point(x * f, y * f);
    }
    public Point vecTo(Point other)
    {
        Point ret = this.negated();
        ret.translate(other);
        return ret;
    }
}
