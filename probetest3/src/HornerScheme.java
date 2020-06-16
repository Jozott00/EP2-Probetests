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
        //TODO: implement this constructor.
        assert p != null;
        this.a = a;
        this.p = p;
    }

    // Creates a polynomial from the coefficients specified by the array coeffs = {a₀, a₁, a₂, ... a𝘥}.
    // Precondition: coeffs != null and coeffs has at least one element.
    public static Polynomial create(int[] coeffs) {
        //TODO: implement this method.
        assert coeffs != null && coeffs.length > 0;

        Polynomial c = new Constant(1);

        for(int i = coeffs.length-1; i >= 0; i-- ) {
            c = new HornerScheme(coeffs[i], c);
        }

        return c;
    }

    public int getA() {
        return a;
    }

    public Polynomial getP() {
        return p;
    }

    @Override
    public int degree() {
        if(p instanceof Constant) {
            return 1;
        }

        return 1+p.degree();
    }

    @Override
    public List<Integer> coefficients() {
        return new ArrayList<>(p.coefficients());
    }

    @Override
    public double eval(double x) {
        return a + x*(p.eval(x));
    }

    @Override
    public Iterator<Integer> iterator() {
        return new HSIterator(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HornerScheme integers = (HornerScheme) o;
        return a == integers.a &&
                Objects.equals(p, integers.p);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, p);
    }

    @Override
    public String toString() {
        return "(" + a + " + x*" + p.toString() + ")";
    }
}


class HSIterator implements Iterator<Integer> {

    private HornerScheme polynomial;
    private Polynomial poly;

    public HSIterator(Polynomial p) {
        if(p instanceof HornerScheme) {
            this.polynomial = (HornerScheme) p;
            poly = p;
        }
        else this.poly = p;
    }

    @Override
    public boolean hasNext() {
       return poly.iterator().hasNext();
    }

    @Override
    public Integer next() throws NoSuchElementException {
       if(hasNext()) {
           if(polynomial != null) {
               if (polynomial.getP() instanceof HornerScheme) {
                    polynomial = (HornerScheme) polynomial.getP();
                    poly = polynomial.getP();
               }
               else{
                   polynomial = null;
               }
               return polynomial.getA();
           }
           return poly.iterator().next();

       }
       throw new NoSuchElementException();
    }
}


