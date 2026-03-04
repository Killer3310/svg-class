public class BoundingBox
{
    public float minX, maxX, minY, maxY;
    public BoundingBox(float minX, float maxX, float minY, float maxY)
    {
        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }
    public String toString()
    {
        return "{" + minX + "," + minY + "; " + maxX + "," + maxY + "}";
    }
}
