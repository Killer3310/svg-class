import java.util.Locale;

public class StrokeShapeDecorator extends ShapeDecorator
{
    private String color;
    private double width;
    public StrokeShapeDecorator(Shape s, String color, double width)
    {
        super(s);
        this.color = color;
        this.width = width;
    }
    @Override
    public String toSvg(String args) {
        return decoratedShape.toSvg(String.format(Locale.ENGLISH, "stroke=\"%s\" stroke-width=\"%f\" %s ", color, width, args));
    }
}
