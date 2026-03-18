import java.util.Locale;

public class TransformDecorator extends ShapeDecorator
{
    public static class Builder
    {
        private String transform = "";
        public Builder() { }
        public Builder translate(Vec2 translation)
        {
            transform += "translate(" + translation.x() + " " + translation.y() + ")\n";
            return this;
        }
        public Builder rotate(float angle, Vec2 center)
        {
            transform += String.format(Locale.ENGLISH, "rotate(%f %f %f)\n", angle, center.x(), center.y());
            return this;
        }
        public Builder scale(Vec2 scale)
        {
            transform += String.format(Locale.ENGLISH, "scale(%f %f)", scale.x(), scale.y());
            return this;
        }
        public Shape build(Shape s)
        {
            return new TransformDecorator(s, this.transform);
        }
    }
    private String tr = "";
    private TransformDecorator(Shape s, String transform)
    {
        super(s);
        tr = transform;
    }
    @Override
    public String toSvg(String args) {
        return super.toSvg(String.format(Locale.ENGLISH, "transform=\"%s\" %s", tr, args));
    }
}
