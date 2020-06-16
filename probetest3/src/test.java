import java.util.ArrayList;

public class test {

    public static void main(String[] args) {

        ArrayList<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(2);
        System.out.println(test);

        ArrayList<Integer> test1 = new ArrayList<>(test);
        System.out.println(test1);
        test.addAll(test1);
        System.out.println(test1);


        Polynomial poly3 = new HornerScheme(2,new HornerScheme(-1, new Constant(3)));
        System.out.println(poly3.hashCode());

    }
}
