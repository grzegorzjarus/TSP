import java.util.ArrayList;
import java.util.List;

public class GUI {

    public static List<Point> points(){
        List<Point> list = new ArrayList<>();
        //list.add(new Point(0,0));
        list.add(new Point(3,4));
        list.add(new Point(7,4));
        list.add(new Point(10,0));
        list.add(new Point(0,0));//
        list.add(new Point(6,-3));
        list.add(new Point(2,-3));
        list.add(new Point(-1,1));
        list.add(new Point(4,3));
        list.add(new Point(3,5));
        list.add(new Point(10,1));
        list.add(new Point(0,1));//
        list.add(new Point(6,-4));
        list.add(new Point(5,-3));
        list.add(new Point(-1,5));
        return list; // distance = 28
    }
}
