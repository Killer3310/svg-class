import java.io.FileWriter;
import java.io.IOException;

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
        if (polygons[0] != null) out = polygons[0].toSvg();
        if (polygons[1] != null) out += '\n' + polygons[1].toSvg();
        if (polygons[2] != null) out += '\n' + polygons[2].toSvg();
        return out;
    }
    public BoundingBox boundingBox()
    {
        int len = polygons[2] == null ? head : 3;
        Point[] arr = polygons[0].getPoints();
        float minX = arr[0].getX(), maxX = minX, minY = arr[0].getY(), maxY = minY;
        for (int i = 0; i < len; i++)
        {
            arr = polygons[i].getPoints();
            for (Point point : arr) {
                float x = point.getX(), y = point.getY();
                if (x < minX) minX = x;
                if (x > maxX) maxX = x;
                if (y < minY) minY = y;
                if (y > maxY) maxY = y;
            }
        }
        return new BoundingBox(minX, maxX, minY, maxY);
    }
    public void save(String path) throws IOException {
        BoundingBox bb = boundingBox();
        float ext = Math.max(Math.max(-bb.minX, bb.maxX), Math.max(-bb.minY, bb.maxY));
        StringBuilder out = new StringBuilder(
                String.format("<svg width=\"1000\" height=\"1000\" viewBox=\"%f %f %f %f\" xmlns=\"http://www.w3.org/2000/svg\">", -ext, -ext, ext * 2, ext * 2));

        out.append("\n<circle fill=\"aliceblue\" cx=\"0\" cy=\"0\" r=\"999\" />");
        int len = polygons[2] == null ? head : 3;
        for (int i = 0; i < len; i++)
        {
            out.append('\n').append(polygons[i].toSvg());
        }
        FileWriter fw = new FileWriter(path, false);
        fw.write(out + "\n</svg>\n");
        fw.close();
    }
}
