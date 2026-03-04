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
    public BoundingBox boundingBox()
    {
        int len = polygons[2] == null ? head : 3;
        Point[] arr = polygons[0].getPoints();
        float minX = arr[0].getX(), maxX = minX, minY = arr[0].getY(), maxY = minY;
        for (int i = 1; i < len; i++)
        {
            for (int j = 0; j < arr.length; j++)
            {
                float x = arr[j].getX(), y = arr[j].getY();
                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
            }
            arr = polygons[i].getPoints();
        }
        return new BoundingBox(minX, maxX, minY, maxY);
    }
}
