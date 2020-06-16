import javax.swing.text.html.HTMLDocument;
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

    private int c;
    // Initializes this object.
    // Precondition: c != 0.
    public Constant(int c) {
        //TODO: implement constructor.
        assert c != 0;

        this.c = c;
    }

    @Override
    public int degree() {
        return 1;
    }

    @Override
    public List<Integer> coefficients() {
        ArrayList<Integer> clist = new ArrayList<>();
        clist.add(c);
        return clist;
    }

    @Override
    public double eval(double x) {
        return c;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new ConstantIterator(c);
    }

    @Override
    public String toString() {
        return "" + c;
    }
}


class ConstantIterator implements Iterator<Integer> {

    private int c;
    private boolean isCalled = false;

    public ConstantIterator(int c) {
        this.c = c;
    }

    @Override
    public boolean hasNext() {
        return !isCalled;
    }

    @Override
    public Integer next() throws NoSuchElementException {
        if(hasNext()) {
            isCalled = true;
            return c;
        }
        throw new NoSuchElementException();
    }
}


