import java.util.List;

public class Point {

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals(Point point) {
        return this.getY() == point.getY() && this.getX() == point.getX();
    }

    public static boolean contains(List<Point> list, Point point) {
        boolean contains = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(point)) contains = true;
        }
        return contains;
    }

    public String toString() {
        return String.valueOf(this.getX()) + " " + String.valueOf(this.getY());
    }

    public static double distance(Point point1, Point point2) {
        return Math.sqrt((Math.pow(point1.getX() - point2.getX(), 2) + Math.pow(point1.getY() - point2.getY(), 2)));
    }
}
