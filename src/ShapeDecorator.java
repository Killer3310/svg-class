public class ShapeDecorator implements Shape
{
    protected Shape decoratedShape;
    public ShapeDecorator(Shape s)
    {
        decoratedShape = s;
    }
    @Override
    public String toSvg(String args) 
    {
        return decoratedShape.toSvg(args);
    }
    @Override
    public BoundingBox boundingBox() 
    {
        return decoratedShape.boundingBox();
    }
}
