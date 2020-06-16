import java.util.Stack;

public class test {


    public static void main(String[] args) {

        Stack<Integer> s = new Stack<>();

        s.push(1);
        s.push(2);
        s.push(s.peek());

        System.out.println(s);
        System.out.println(s.peek());

        System.out.println(Math.pow(-2,3));

    }

}
