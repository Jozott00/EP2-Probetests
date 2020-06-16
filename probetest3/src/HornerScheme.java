import java.util.*;

// The class implements 'Polynomial' and represents the form (a + x*p), where 'a' is an Integer
// and 'p' is another polynomial. 'p' must not be 'null' (objects of 'Constant' shall be used to represent constants).
// This class implements 'Polynomial' by using Horner's scheme.
// Example:
// a₀ + a₁*x + a₂*x² + a₃*x³ + a₄*x⁴
// The polynomial above is represented in Horner's scheme as:
// a₀ + x*(a₁ + x*(a₂ + x*(a₃ + x*a₄)))
//
public class HornerScheme implements Polynomial {

    //TODO: define missing parts of this class.
    private int a;
    private Polynomial p;

    // Initializes this object.
    // Precondition: 'p' must not be 'null'.
    public HornerScheme(int a, Polynomial p) {
        assert p != null;
        //TODO: implement this constructor.

        this.a = a;
        this.p = p;
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        //TODO: implement this method.
        assert coeffs != null;
        Polynomial poly = new Constant(coeffs[coeffs.length-1]);
        if(coeffs.length > 1)
            for(int i = coeffs.length-2; i >= 0;i-- ) {
                poly = new HornerScheme(coeffs[i], poly);
            }

        return poly;
    }

    @Override
    public int degree() {
        return 1 + p.degree();
    }

    @Override
    public List<Integer> coefficients() {
        return new ArrayList<>(p.coefficients());
    }

    @Override
    public double eval(double x) {
        return a + x*p.eval(x);
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HSIterator(a, p);
    }


    // Not sure about equals()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HornerScheme other = (HornerScheme) o;

        return this.eval(1) == other.eval(1);
    }

    @Override
    public int hashCode() {
        return a*31*(p.hashCode()%a+31 + 2);
    }

    @Override
    public String toString() {
        return "(" + a + " + x*" + p.toString() + ")";
    }
}

class  HSIterator implements Iterator{

    private int a;
    private Iterator iter;
    private boolean wasCalled = false;

    public HSIterator(int a, Polynomial p) {
        this.a = a;
        this.iter = p.iterator();
    }


    @Override
    public boolean hasNext() {
        return iter.hasNext();
    }

    @Override
    public Object next() {
        if(!wasCalled) {
            wasCalled = true;
            return a;
        }
        return iter.next();
    }
}



