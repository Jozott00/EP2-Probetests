public class test {

    public static void main(String[] args) {
        String test = "test";

        char c = test.charAt(2);
        System.out.println(c);
        System.out.println(test.substring(0, 2-1) + 'E' + test.substring(2, 4));

        System.out.println(Character.toString(99999));

        StringOperator rep1 = new ReplaceOperator('a', 'b');
        StringOperator rep2 = new ReplaceOperator('b', 'y');
        StringOperator rep = new ComposedOperator(rep1, rep2);

        System.out.println(rep);

        System.out.println(rep.hashCode());
        System.out.println(rep1.hashCode());
        System.out.println(rep2.hashCode());

    }

}