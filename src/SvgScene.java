public class SvgScene
{
    private Polygon[] polygons = new Polygon[3];
    private int head = 0;
    public void addPolygon(Polygon p)
    {
        polygons[head++] = new Polygon(p);
        head %= 3;
    }
    public String toSVG()
    {
        String out = "";
        if (polygons[0] != null) out = polygons[0].toSVG();
        if (polygons[1] != null) out += '\n' + polygons[1].toSVG();
        if (polygons[2] != null) out += '\n' + polygons[2].toSVG();
        return out;
    }
}
