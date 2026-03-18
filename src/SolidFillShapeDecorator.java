import java.util.Locale;

public class SolidFillShapeDecorator extends ShapeDecorator
{
    private String color;
    public SolidFillShapeDecorator(Shape s, String color)
    {
        super(s);
        this.color = color;
    }
    @Override
    public String toSvg(String args) {
        return super.toSvg(String.format(Locale.ENGLISH, "fill=\"%s\" %s ", color, args));
    }
}