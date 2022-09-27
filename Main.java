package fourte;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Enter the question ");
		int qus = sn.nextInt();
		sn.nextLine();
		List<Object> eq = new LinkedList<Object>();
		for (int i = 1; i <= 4; i++) {
			System.out.println("Enter the number " + i);
			eq.add(sn.nextLine());
		}
		Solution obj = new Solution();
		obj.solu(qus, eq);
	}
}
