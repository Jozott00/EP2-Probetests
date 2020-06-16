import java.util.*;

// This class implements 'StringOperator' and represents a composition of two 'StringOperator' objects that
// are applied in succession (both can be 'ComposedOperator' objects themselves).
// Calling this object's 'apply' method returns the result of applying the second 'StringOperator'
// on the result of applying the first one on the specified string.
// 'ComposedOperator' objects can be build using the 'andThen' method specified in the interface 'StringOperator'.
//
public class ComposedOperator implements StringOperator {

    StringOperator firstOp;
    StringOperator secondOp;

    public ComposedOperator(StringOperator firstOp, StringOperator secondOp) {
        this.firstOp = firstOp;
        this.secondOp = secondOp;
    }

    @Override
    public String apply(String operand) {
       return secondOp.apply(firstOp.apply(operand));
    }

    @Override
    public StringOperator andThen(StringOperator after) {
        assert after != null;
        return new ComposedOperator(this, after);
    }

    @Override
    public Iterator<StringOperator> iterator() {
        return new COIterator(firstOp, secondOp);
    }

    //TODO: define missing parts of this class.


    @Override
    public String toString() {
        String s = "";
        if(firstOp instanceof ReplaceOperator) s +=  firstOp;
        else s += firstOp;

        if(secondOp instanceof ReplaceOperator)s += " and then " + secondOp;
        else s += secondOp;

        return s;
    }

    public boolean equals(Object o) {
        if(!(o instanceof ComposedOperator)) return false;

        ComposedOperator other = (ComposedOperator) o;

        if(this.firstOp.equals(other.firstOp) && this.secondOp.equals(other.secondOp)) return true;
        return false;
    }

    @Override
    public int hashCode() {

        int hashCode = 0;

        for (int i = 0; i < 31; i++) {
            hashCode += firstOp.hashCode() * secondOp.hashCode() / 3;
            hashCode *= hashCode % 31;
        }

        return hashCode;

    }
}

class COIterator implements Iterator {

    private Iterator first;
    private Iterator second;

    public COIterator(StringOperator first, StringOperator second) {
        this.first = first.iterator();
        this.second = second.iterator();
    }

    @Override
    public boolean hasNext() {
        return first.hasNext() || second.hasNext();
    }

    @Override
    public Object next() throws NoSuchElementException {
        if(first.hasNext()) {
            return first.next();
        }
        if(second.hasNext()) return second.next();

        throw new NoSuchElementException();
    }
}

