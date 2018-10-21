import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //System.out.println(Point.distance(new Point(0,0), new Point(3,4)));
        //System.out.println(Genetic.wholeDistance(GUI.points()));
        //System.out.println(Genetic.distanceALL(Genetic.initialPopulation(GUI.points())));
        //Genetic.printDistance(Genetic.selection(Genetic.initialPopulation(GUI.points())));
//        List<List<Point>> list = Genetic.initialPopulation(GUI.points());
//        System.out.println(Genetic.distanceALL(list));
//        System.out.println(Genetic.distanceALL(Genetic.selection(list)));
        System.out.println(Genetic.algorithm());
        List<List<Point>> list2=new ArrayList<>();
        for(int i=0; i<100; i++){
            list2.add(Genetic.crossOver(GUI.points()));
        }
        //Genetic.printList(list2);
    }
}
