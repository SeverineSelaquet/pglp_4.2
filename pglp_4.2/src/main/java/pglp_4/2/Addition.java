
public class Addition implements Command{
	
	String symbole;
	
	public Addition(char symbole) {
		this.symbole = "+";
	}
	
	@Override
	public double execute(double a, double b) {
		return a+b;
	}

	@Override
	public void undo() {
		
	}
	
	public String getSymbole() {
		return symbole;
	}

}
