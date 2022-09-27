package fourte;

import java.util.LinkedList;
import java.util.List;

public class Calculation {
	public double calculate(String problem) {
		Expression ob1 = new Expression();
		Validation ob2 = new Validation();
		LinkedList<Object> terms = new LinkedList<Object>();
		if (ob2.check(problem)) {
			terms = ob1.toTerms(problem);
			return solve(terms);
		} else {
			return 0.0;
		}

	}

	Double solve(List<Object> terms) {
		int i, j;
		Double a;
		List<Object> terms1 = new LinkedList<Object>();
		while (terms.size() > 1) {
			if (terms.contains("(")) {
				i = terms.indexOf("(");
				j = terms.indexOf(")");
				terms1 = terms.subList(i + 1, j + 1);
				if (terms1.contains("(")) {
					i = terms1.indexOf("(");
					j = terms1.indexOf(")");
					a = solve(terms1.subList(i + 1, j));
					terms1.remove("(");
					terms1.remove(")");
				} else {
					a = solve(terms.subList(i + 1, j));
					terms.remove("(");
					terms.remove(")");
				}

			} else if (terms.contains("/")) {
				i = terms.indexOf("/");
				a = Double.valueOf((terms.get(i - 1)).toString()) / Double.valueOf((terms.get(i + 1)).toString());
				toSimplify(terms, i, 3, a);
			} else if (terms.contains("*")) {
				i = terms.indexOf("*");
				a = Double.valueOf((terms.get(i - 1)).toString()) * Double.valueOf((terms.get(i + 1)).toString());
				toSimplify(terms, i, 3, a);
			} else if (terms.contains("-")) {
				i = terms.indexOf("-");
				a = Double.valueOf((terms.get(i - 1)).toString()) - Double.valueOf((terms.get(i + 1)).toString());
				toSimplify(terms, i, 3, a);
			} else if (terms.contains("+")) {
				i = terms.indexOf("+");
				a = Double.valueOf((terms.get(i - 1)).toString()) + Double.valueOf((terms.get(i + 1)).toString());
				toSimplify(terms, i, 3, a);
			}
		}
		return (Double) terms.get(0);

	}


	void toSimplify(List<Object> a, int i, int n, Double ans) {
		a.add(i - 1, ans);
		while (n-- > 0) {
			a.remove(i);
		}

	}
}
