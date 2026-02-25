public class Point {
    public float x = 0, y = 0;
    public String toString()
    {
        return String.format("{%.1f; %.1f}", x, y);
    }
}
