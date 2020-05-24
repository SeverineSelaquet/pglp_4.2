import java.util.Scanner;

public class SaisieRPN {
	private Scanner sc;

	public SaisieRPN() {
		sc = new Scanner(System.in);
	}


	public void saisie() {

		MoteurRPN m = new MoteurRPN();
		double res = 0;
		String end = "continue";

		while (!end.equals("exit")) {
			System.out.println("Veuillez saisir un nombre suivi d'un opérateur ou 'exit' pour eteindre :");

			if (sc.hasNextDouble()) {
				m.addOperande(sc.nextDouble());

				sc.nextLine();

			} else {
				String operateur = sc.nextLine();
				end = operateur;

				try {
					if (end.equals("exit")) {
						continue;
					}
					if (operateur.equals("+"))
						res = m.calcul(Addition a);
					else if (operateur.equals("-"))
						res = m.calcul(Operation.MOINS);
					else if (operateur.equals("*"))
						res = m.calcul(Operation.MULT);
					else if (operateur.equals("/"))
						res = m.calcul(Operation.DIV);
					else if (operateur.equals("exit")) {
					} else {
						throw new ValueException();
					}

					if (!operateur.equals("exit")) {
						m.addOperande(res);
						System.out.println("resultat =" + res);
					}

				} catch (OperandeInsuffisanteException e1) {

					System.err.println(e1.getMessage());
				}

				catch (ArithmeticException e2) {
					System.err.println("Error!! Division par 0");
				}

				m.printOperandes();

			}

		}

		System.out.println("FIN");
	}

}
