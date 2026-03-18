import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Polygon triangle = new Polygon(new Vec2[]{
                new Vec2(0, 0),
                new Vec2(300, 0),
                new Vec2(150, 250)
        });

        Polygon rectangle = new Polygon(new Vec2[]{
                new Vec2(350, 0),
                new Vec2(750, 0),
                new Vec2(750, 200),
                new Vec2(350, 200)
        });

        Polygon pentagon = new Polygon(new Vec2[]{
                new Vec2(0, 260),
                new Vec2(100, 460),
                new Vec2(300, 560),
                new Vec2(500, 460),
                new Vec2(600, 260)
        });

        Ellipse ellipse = new Ellipse(new Vec2(500, 700), 400, 100);

        SolidFilledPolygon sfp = new SolidFilledPolygon(new Vec2[] { new Vec2(0, 0), new Vec2(100, 100), new Vec2(200, 0) }, "red");

        Shape decorEllipse = new StrokeShapeDecorator(new SolidFillShapeDecorator(ellipse, "green"), "cyan", 5);

        Shape tr = new TransformDecorator.Builder().translate(new Vec2(0, 50)).rotate(30, new Vec2(400, 400)).scale(new Vec2(.5, .5)).build(decorEllipse);

        SvgScene scene = new SvgScene();
        scene.addShape(triangle);
        scene.addShape(rectangle);
        scene.addShape(pentagon);
        scene.addShape(ellipse);
        scene.addShape(sfp);
        scene.addShape(decorEllipse);
        scene.addShape(tr);
        scene.save("result.svg");
    }
}
