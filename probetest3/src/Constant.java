import java.util.*;

// 'Constant' implements 'Polynomial' and represents a polynomial with degree 0 corresponding
// to a constant value (regardless of the 'x' used for evaluation).
// 'Constant' is used by class 'HornerScheme'.
// The iterator of this class iterates over only one value and therefore behaves as follows:
// The 'next' method returns the constant value, if it is called for the first time.
// 'hasNext' is 'true' only if 'next' has not been called.
//
public class Constant implements Polynomial {

    //TODO: define missing parts of this class.

    private int constant;

    // Initializes this object.
    // Precondition: c != 0.
    public Constant(int c) {

        //TODO: implement constructor.
        this.constant = c;

    }

    @Override
    public int degree() {
        return 0;
    }

    @Override
    public List<Integer> coefficients() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(constant);
        return list;
    }

    @Override
    public double eval(double x) {
        return constant;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new CIterator(constant);
    }

    @Override
    public String toString() {
        return"" + constant;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant other = (Constant) o;
        return constant == other.constant;
    }

    @Override
    public int hashCode() {
        return constant*63;
    }
}

class CIterator implements Iterator {

    int constant;
    boolean wasCalled = false;

    public CIterator (int constant){
        this.constant = constant;
    }

    @Override
    public boolean hasNext() {
        return !wasCalled;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if(!hasNext()) throw new NoSuchElementException("no coefficient!");

        wasCalled = true;
        return constant;
    }
}


