package fourte;

public class Validation {
	boolean check(String cal) {
		String[] a = cal.split("");
		char[] type = new char[a.length];
		for (int i = 0; i < a.length; i++) {
			char value = a[i].charAt(0);
			if (value > 47 & value < 58)
				type[i] = 'N'; // number
			else if ((value == 43) || (value == 45) || (value == 42) || (value == 47))
				type[i] = 'O'; // operation
			else if ((value == 40) || (value == 41))
				type[i] = 'B'; // bracket
		}
		if (type[0] == 'O')
			return false;
		else if (type[a.length - 1] == 'O')
			return false;
		else {
			for (int i = 0; i < a.length - 1; i++) {
				if (type[i] == 'O' && type[i + 1] == 'O')
					return false;
			}
		}
		return true;
	}
}
