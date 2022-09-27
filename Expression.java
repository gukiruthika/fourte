package fourte;

import java.util.LinkedList;

public class Expression {
	LinkedList<Object> toTerms(String problem) {
		String[] term = problem.split("");
		char[] type = new char[term.length];
		for (int i = 0; i < term.length; i++) {
			char value = term[i].charAt(0);
			if (value > 47 & value < 58)
				type[i] = 'N'; // number
			else if (value == 45)
				type[i] = 'M'; // minus
			else if (value == 40)
				type[i] = 'B'; // open bracket
			else if (value == 41)
				type[i] = 'C'; // close bracket
			else
				type[i] = 'O'; // others
		}

		LinkedList<Object> terms = new LinkedList<Object>();
		for (int i = 0; i < term.length; i++) {
			if (type[i] == 'N') {
				double x = Double.valueOf(term[i]);
				if (i >= 1 && (type[i - 1] == 'M')) {
					x = -x;
					terms.removeLast();
					if (i >= 2 && (type[i - 2] == 'N' | type[i - 2] == 'C')) {
						x = -x;
						terms.add("-");
					}
				}
				while (i < term.length - 1 && (type[i + 1] == 'N')) {
					++i;
					x = x * 10 + (Double.valueOf(term[i]));
				}

				terms.add(x);
			} else if (type[i] == 'B') {
				if (i >= 1 && ((type[i - 1] == 'N') || (type[i - 1] == 'C'))) {
					terms.add("*");
				}
				terms.add("(");
			} else if (type[i] == 'C') {
				terms.add(")");
				if (i < type.length - 1 && (type[i + 1] == 'N')) {
					terms.add("*");
				}
			} else {
				terms.add(term[i]);
			}
		}
		return terms;
	}
}
