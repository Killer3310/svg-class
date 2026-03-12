public class Ellipse extends Shape
{
    private Point center;
    private float rx, ry;
    public Ellipse(Point center, float rx, float ry, Style style)
	{
		super(style);
		this.center = new Point(center);
		this.rx = rx;
		this.ry = ry;
	}

	public Ellipse(Point center, float rx, float ry)
	{
		super();
		this.center = new Point(center);
		this.rx = rx;
		this.ry = ry;
	}

	public Ellipse(Ellipse e)
	{
		this(e.center, e.rx, e.ry, e.style);
	}
    public String toSvg()
    {
        return String.format("<ellipse cx=\"%.5f\" cy=\"%.5f\" rx=\"%.5f\" ry=\"%.5f\" %s />",
                center.getX(), -center.getY(),
                rx, ry,
                style.toSvg());
    }
    public BoundingBox getBounds()
    {
        return new BoundingBox(center.getX() - rx, center.getX() + rx, center.getY() - ry, center.getY() + ry);
    }

	public Ellipse copy()
	{
		return new Ellipse(this);
	}
}
