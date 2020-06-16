import java.util.*;

// This class implements 'StringOperator' and represents a simple replacement operation on a string.
// It replaces the all occurrences of the specified 'oldChar' with 'newChar'.
// The iterator of this class iterates over only one element and therefore behaves as follows:
// The 'next' method returns 'this', if it is called for the first time.
// 'hasNext' is 'true' only if 'next' has not been called.
//
public class ReplaceOperator implements StringOperator {

    //TODO: define variables.
    private char oldChar;
    private char newChar;

    // Constructor of the 'ReplaceOperator'.
    public ReplaceOperator(char oldChar, char newChar) {
        this.oldChar = oldChar;
        this.newChar = newChar;
    }

    @Override
    public String apply(String operand) {
        for(int i = 0; i < operand.length(); i++) {
            if(operand.charAt(i) == oldChar) operand = operand.substring(0, i) + newChar + operand.substring(i+1);
        }

        return operand;
    }

    @Override
    public StringOperator andThen(StringOperator after) {
        assert after != null;
        return new ComposedOperator(this, after);
    }

    @Override
    public Iterator<StringOperator> iterator() {
        return new ROIterator(this);
    }

    @Override
    public int hashCode() {

        String hashingString = "";
        int hashCode = 1;

        for (int i = 0; i < oldChar + newChar; i++) {
            hashCode += oldChar + (newChar * 31);
            hashCode *= hashCode % 5 + 1;
        }
        return hashCode;
    }

    @Override
    public String toString() {
        return "replace '" + oldChar + "' with '" + newChar + "'";
    }

    public boolean equals(Object o) {
        if(!(o instanceof ReplaceOperator)) return false;

        ReplaceOperator other = (ReplaceOperator) o;
        if(other.newChar == other.oldChar) return true;
        return false;
    }

    //TODO: define missing parts of this class.
}

class ROIterator implements Iterator{

    boolean wasCalled = false;
    StringOperator curr;

    public ROIterator(StringOperator curr) {
        this.curr = curr;
    }

    @Override
    public boolean hasNext() {
        return !wasCalled;
    }

    @Override
    public Object next() throws NoSuchElementException {
        if(!hasNext()) throw new NoSuchElementException("no operator!");
        wasCalled = true;
        return curr;
    }
}
