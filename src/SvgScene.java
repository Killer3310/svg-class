public class SvgScene
{
    private Polygon[] polygons = new Polygon[3];
    private int head = 0;
    public void addPolygon(Polygon p)
    {
        polygons[head++] = new Polygon(p);
        head %= 3;
    }
}
