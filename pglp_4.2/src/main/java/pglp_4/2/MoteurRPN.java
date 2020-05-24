import java.util.Stack;

public class MoteurRPN {
	public Stack<Double> operande;

	public MoteurRPN() {
		operande = new Stack<Double>();
	}


	public void addOperande(double d) {
		operande.push(d);
		printOperandes();
	}

	
	public double calcul(Command c) throws OperandeInsuffisanteException {
		if (operande.size() < 2) {
			throw new OperandeInsuffisanteException();
		} 
		double op1 = operande.pop();
		double op2 = operande.pop();
			
		System.out.println(op1 + " " + c.getSymbole() + " " + op2);
		double res = 0;
		res = c.execute(op1, op2);
		return res;
	}


	/**
	 * Print the content of the pile
	 */
	public void printOperandes() {
		System.out.println("Liste des operandes: " + operande.toString());
	}
}
