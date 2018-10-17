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

    public static double distance(Point point1, Point point2){
        return Math.sqrt((Math.pow(point1.getX()-point2.getX(),2)+ Math.pow(point1.getY()-point2.getY(),2)));
    }
}
