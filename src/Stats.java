import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;

/**
 * Created by XianSheng on 2016/12/14.
 */
public class Stats {
    public static void main(String[] args) {
        Bag<Double> numbers = new Bag<>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
            int N = numbers.size();
            if (N == 5) {
                double sum = 0.0;
                for (double x : numbers) {
                    System.out.println(x);
                    sum += x;
                }
                double mean = sum / N;
                System.out.println(mean);
                System.out.println(sum);
            }
        }

    }
}
