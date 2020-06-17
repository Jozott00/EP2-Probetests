// This class represents a polynomial. A polynomial is a sum of multiple monomials (class 'Monomial'),
// such as 3*x^1 + -1*x^2 + 1*x^5.
// 'Polynomial' uses a binary search tree to store its monomials. The degree of the monomial is the key.
// A specific degree exists at most once in the polynomial.
// TODO: define further classes for the implementation of the binary search tree, if needed

public class Polynomial {

    //TODO: declare variables
    PolyNode root;

    // Initializes this polynomial with multiple monomials. The coefficients of the monomials are
    // specified by 'coeffs', where coeffs[i] is the coefficient of the monomial of degree i.
    // Entries with value 0 are ignored, i.e. corresponding monomials are not stored in the polynomial.
    public Polynomial(int[] coeffs) {
        // TODO: implement this constructor
        for (int i = 0; i < coeffs.length; i++) {
            add(coeffs[i], i);
        }
    }

    // Adds the monomial specified by 'coeff' and 'degree' to this polynomial, if coeff != 0,
    // otherwise 'add' has no effect.
    // If this polynomial already has a monomial of the same degree, no new monomial is added, instead
    // the coefficient of the monomial is modified accordingly ('combine' is called).
    public void add(int coeff, int degree) {
        // TODO: implement this method
        if(coeff == 0) return;
        Monomial m = new Monomial(coeff, degree);
        if(root == null){
            root = new PolyNode(m);
            return;
        }
        root.add(m);
    }

    // Adds all monomials of 'p' to this polynomial.
    // (The rules of 'add(int,int)' apply for each monomial to be added.)
    public void add(Polynomial p) {
        // TODO: implement this method
        p.root.addTo(this.root);
    }

    // Returns the value of the polynomial for a specified value of 'x'
    public int eval(int x) {
        // TODO: implement this method
        return root.eval(x);
    }

    // Returns a polynomial representation in mathematical notation such as
    // "2*x^0 + 6*x^2 + -2*x^3", where monomials are ordered ascending according to
    // their degree. Note that a positive sign of the leftmost coefficient is
    // not shown.
    // Returns the string "0" if the polynomial has no monomials (is empty).
    public String toString() {
        // TODO: implement this method
        if(root == null) return "0";
        return root.toString();
    }

}

class PolyNode {

    Monomial m;
    PolyNode left;
    PolyNode right;

    public PolyNode(Monomial m) {
        this.m = m;
    }


    public void add(Monomial monomial) {
        if(m.combine(monomial)) return;
        if(monomial.lowerDegreeThan(m)) {
            if(left == null) left = new PolyNode(monomial);
            else left.add(monomial);
        } else {
            if(right == null) right = new PolyNode(monomial);
            else right.add(monomial);
        }
    }

    public void addTo(PolyNode tree) {
        tree.add(m);
        if(left != null) left.addTo(tree);
        if(right != null) right.addTo(tree);
    }

    public int eval(int x) {
        int sum = m.eval(x);
        if(left != null) sum += left.eval(x);
        if(right != null) sum += right.eval(x);
        return sum;
    }

    @Override
    public String toString() {
        if(left == null && right == null) return m.toString();
        String s = m.toString();
        if(left != null) s = left.toString() + " + " + s;
        if(right != null) s += " + " + right.toString();
        return s;
    }
}

