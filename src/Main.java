// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.print("Hello and welcome!\n");
        Point p = new Point();
        p.x = 1;
        p.y = 2;
        System.out.println(p.toSVG());
        System.out.println(p.translated(10, 4));
        p.translate(-1, -3);
        System.out.println(p);
    }
}