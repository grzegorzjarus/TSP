import java.util.ArrayList;
import java.util.List;

public class Genetic {
    //List<Point> points = GUI.points();
    static List<List<Point>> result;

    //points = GUI.points();

    public static double algorithm() {

        List<List<Point>> population = initialPopulation(GUI.points());
        double best = wholeDistance(population.get(0));
        for (int i = 0; i < 1000; i++) {
            population = selection(population);
            System.out.println("Best= " + best);
            for (int j = 0; j < population.size() - 1; j=j+2) {
                List<Point> list1 = crossOver(population.get(j),population.get(j+1));
                if (wholeDistance(list1) < best) {
                    best = wholeDistance(list1);
                    population.set(j, list1);
                }
            }
        }
        return best;
    }

    public static double wholeDistance(List<Point> list) {
        double distance = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            distance += Point.distance(list.get(i), list.get(i + 1));
        }
        return distance;
    }

    public static List<List<Point>> initialPopulation(List<Point> list) {
        List<Point> chromosome = new ArrayList<>();
        List<List<Point>> initialPopulation = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            chromosome = new ArrayList<>();
            for (int j = 0; chromosome.size() != list.size(); j++) {
                int random = (int) (Math.random() * list.size());
                if (!(chromosome.contains(list.get(random)))) {
                    chromosome.add(list.get(random));
                } else j--;

            }
            initialPopulation.add(chromosome);
        }
        return initialPopulation;
    }

    public static void printDistance(List<List<Point>> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            System.out.println(wholeDistance(list.get(i)));
        }
        System.out.println("Best = " + findBest(list));
        System.out.println("Last = " + findLast(list));
    }

    public static double findBest(List<List<Point>> list) {
        double best = wholeDistance(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            if (wholeDistance(list.get(i)) < best) {
                best = wholeDistance(list.get(i));
            }
        }
        return best;
    }

    public static double findLast(List<List<Point>> list) {
        double last = 0;
        for (int i = 0; i < list.size(); i++) {
            if (wholeDistance(list.get(i)) > last) {
                last = wholeDistance(list.get(i));
            }
        }
        return last;
    }

    public static double distanceALL(List<List<Point>> list) {
        double result = 0;
        for (int i = 0; i < list.size(); i++) {
            result += wholeDistance(list.get(i));
        }
        return result;
    }

    public static List<List<Point>> selection(List<List<Point>> list) {
        List<List<Point>> result = new ArrayList<>();
        List<List<Point>> selectionList = new ArrayList<>();
        double last = findLast(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < last - wholeDistance(list.get(i)) + 1; j++) {
                selectionList.add(list.get(i));
            }
        }
        System.out.println("Counter = " + selectionList.size());

        for (int i = 0; i < list.size(); i++) {
            result.add(selectionList.get((int) (Math.random() * selectionList.size())));
        }
        return result;
    }

    public static List<Point> crossOver(List<Point> list) {
        double distance = wholeDistance(list);
        List<Point> child = new ArrayList<>();
        for (int i = 0; i < list.size(); ) {
            int random = (int) (Math.random() * list.size());
            if (!child.contains(list.get(random))) {
                child.add(list.get(random));
                i++;
            }
        }
        return wholeDistance(child) < distance ? child : list;


    }

    public static List<Point> crossOver(List<Point> parent1, List<Point> parent2) {

        int start = 3;// (int) (Math.random() * parent1.size());
        int potencialEnd = (int) (Math.random() * parent1.size()) + start + 1;
        int end = 9;//(potencialEnd<parent1.size()? potencialEnd:parent1.size());

        List<Point> copy= new ArrayList<>();//to avoid ConcurrentModificationException
        copy.addAll(parent1);

        List<Point> child = copy.subList(start, end);

        for (int i = 0; i < parent2.size(); i++) {
            Point point = parent2.get(i);
            if (!Point.contains(child,point)) {
                child.add(point);
            }
        }
        return child;
    }


    public static void printList(List<List<Point>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + "   ");
            }
            System.out.println(" ");
        }
    }
}
